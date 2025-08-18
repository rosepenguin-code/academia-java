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

        System.out.print("IVA do produto (6, 13 ou 23): ");
        int iva = Integer.parseInt(sc.nextLine());

        System.out.print("Desconto (entre 0 e 1): ");
        double desconto = Double.parseDouble(sc.nextLine());

        System.out.print("ID da prateleira: ");
        long shelfId = Long.parseLong(sc.nextLine());

        Product produto = new Product(nome, preco, iva, desconto, shelfId);
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

        System.out.print("Novo preço [" + produto.getPrice() + "]: ");
        String precoStr = sc.nextLine();
        if (!precoStr.isEmpty()) produto.setPrice(Double.parseDouble(precoStr));

        System.out.print("Novo IVA [" + produto.getIva() + "]: ");
        String ivaStr = sc.nextLine();
        if (!ivaStr.isEmpty()) produto.setIva(Integer.parseInt(ivaStr));

        System.out.print("Novo desconto [" + produto.getDiscount() + "]: ");
        String descontoStr = sc.nextLine();
        if (!descontoStr.isEmpty()) produto.setDiscount(Double.parseDouble(descontoStr));

        System.out.print("Nova prateleira [" + produto.getShelfId() + "]: ");
        String shelfStr = sc.nextLine();
        if (!shelfStr.isEmpty()) produto.setShelfId(Long.parseLong(shelfStr));

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
