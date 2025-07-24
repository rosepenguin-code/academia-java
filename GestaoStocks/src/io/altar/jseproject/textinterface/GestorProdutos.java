package io.altar.jseproject.textinterface;

import java.util.Optional;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class GestorProdutos {
    private static final ProductRepository productRepo = ProductRepository.getInstance();

    public static void listarProdutos(Scanner sc) {
        if (productRepo.isEmpty()) {
            System.out.println("Não existem produtos registados.");
            return;
        }

        System.out.println("--- Lista de Produtos ---");
        for (Long id : productRepo.getAllIds()) {
            productRepo.readById(id).ifPresent(System.out::println);
        }
    }

    public static void criarProduto(Scanner sc) {
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();

        System.out.print("Preço do produto: ");
        double preco = Double.parseDouble(sc.nextLine());

        System.out.print("O produto tem IVA? (s/n): ");
        String ivaInput = sc.nextLine().trim().toLowerCase();
        boolean temIVA = ivaInput.equals("s");

        Product produto = new Product(nome, preco, temIVA);
        productRepo.create(produto);

        System.out.println("Produto criado com o ID: " + produto.getId());
    }

    public static void editarProduto(Scanner sc) {
        System.out.print("ID do produto a editar: ");
        long id = Long.parseLong(sc.nextLine());

        Optional<Product> optProduto = productRepo.readById(id);
        if (optProduto.isPresent()) {
            System.out.println("Produto não encontrado.");
            return;
        }

        Product produto = optProduto.get();

        System.out.print("Novo nome [" + produto.getNome() + "]: ");
        String nome = sc.nextLine();
        if (!nome.isEmpty()) produto.setNome(nome);

        System.out.print("Novo preço [" + produto.getPreco() + "]: ");
        String precoStr = sc.nextLine();
        if (!precoStr.isEmpty()) produto.setPreco(Double.parseDouble(precoStr));

        System.out.print("Tem IVA? (s/n) [" + (produto.isTemIVA() ? "s" : "n") + "]: ");
        String ivaInput = sc.nextLine().trim().toLowerCase();
        if (ivaInput.equals("s") || ivaInput.equals("n")) {
            produto.setTemIVA(ivaInput.equals("s"));
        }

        productRepo.update(produto);
        System.out.println("Produto atualizado.");
    }

    public static void removerProduto(Scanner sc) {
        System.out.print("ID do produto a remover: ");
        long id = Long.parseLong(sc.nextLine());

        if (productRepo.readById(id).isPresent()) {
            System.out.println("Produto não encontrado.");
            return;
        }

        productRepo.delete(id);
        System.out.println("Produto removido.");
    }
}
