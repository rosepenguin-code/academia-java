package io.altar.jseproject.textinterface;

import java.util.Optional;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class GestorPrateleiras {
    private static final ShelfRepository shelfRepo = ShelfRepository.getInstance();
    private static final ProductRepository productRepo = ProductRepository.getInstance();

    public static void listarPrateleiras(Scanner sc) {
        if (shelfRepo.isEmpty()) {
            System.out.println("Não existem prateleiras registadas.");
            return;
        }

        System.out.println("--- Lista de Prateleiras ---");
        for (Long id : shelfRepo.getAllIds()) {
            shelfRepo.readById(id).ifPresent(System.out::println);
        }
    }

    public static void criarPrateleira(Scanner sc) {
        System.out.print("Localização da prateleira: ");
        String localizacao = sc.nextLine();

        System.out.print("Capacidade da prateleira: ");
        int capacidade = Integer.parseInt(sc.nextLine());

        System.out.print("Preço diário de aluguer: ");
        double precoDiario = Double.parseDouble(sc.nextLine());

        Shelf shelf = new Shelf(localizacao, capacidade, precoDiario);

        System.out.print("Deseja adicionar um produto à prateleira? (s/n): ");
        String opcao = sc.nextLine().trim().toLowerCase();

        if (opcao.equals("s")) {
            System.out.print("ID do produto a adicionar: ");
            long idProduto = Long.parseLong(sc.nextLine());

            Optional<Product> produtoOpt = productRepo.readById(idProduto);
            if (produtoOpt.isPresent()) {
                shelf.setProduto(produtoOpt.get());
                System.out.println("Produto atribuído à prateleira.");
            } else {
                System.out.println("Produto com ID " + idProduto + " não encontrado.");
            }
        }

        shelfRepo.create(shelf);
        System.out.println("Prateleira criada com o ID: " + shelf.getId());
    }

    public static void editarPrateleira(Scanner sc) {
        System.out.print("ID da prateleira a editar: ");
        long id = Long.parseLong(sc.nextLine());

        Optional<Shelf> optShelf = shelfRepo.readById(id);
        if (optShelf.isPresent()) {
            System.out.println("Prateleira não encontrada.");
            return;
        }

        Shelf shelf = optShelf.get();

        System.out.print("Nova localização [" + shelf.getLocalizacao() + "]: ");
        String localizacao = sc.nextLine();
        if (!localizacao.isEmpty()) shelf.setLocalizacao(localizacao);

        System.out.print("Nova capacidade [" + shelf.getCapacidade() + "]: ");
        String capStr = sc.nextLine();
        if (!capStr.isEmpty()) shelf.setCapacidade(Integer.parseInt(capStr));

        System.out.print("Novo preço diário [" + shelf.getPrecoDiario() + "]: ");
        String precoStr = sc.nextLine();
        if (!precoStr.isEmpty()) shelf.setPrecoDiario(Double.parseDouble(precoStr));

        System.out.print("Deseja mudar o produto? (s/n): ");
        String opcao = sc.nextLine().trim().toLowerCase();
        if (opcao.equals("s")) {
            System.out.print("ID do novo produto (ou deixe vazio para remover): ");
            String novoId = sc.nextLine();

            if (novoId.isEmpty()) {
                shelf.setProduto(null);
                System.out.println("Produto removido da prateleira.");
            } else {
                Optional<Product> novoProduto = productRepo.readById(Long.parseLong(novoId));
                if (novoProduto.isPresent()) {
                    shelf.setProduto(novoProduto.get());
                    System.out.println("Produto atualizado.");
                } else {
                    System.out.println("Produto com esse ID não existe.");
                }
            }
        }

        shelfRepo.update(shelf);
        System.out.println("Prateleira atualizada.");
    }

    public static void removerPrateleira(Scanner sc) {
        System.out.print("ID da prateleira a remover: ");
        long id = Long.parseLong(sc.nextLine());

        if (shelfRepo.readById(id).isPresent()) {
            System.out.println("Prateleira não encontrada.");
            return;
        }

        shelfRepo.delete(id);
        System.out.println("Prateleira removida.");
    }
}
