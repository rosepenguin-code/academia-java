package io.altar.jseproject.main;

import io.altar.jseproject.business.ProductManager;
import io.altar.jseproject.business.ShelfManager;
import io.altar.jseproject.controller.Controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductManager productManager = new ProductManager();
        ShelfManager shelfManager = new ShelfManager();
        Controller controller = new Controller(productManager, shelfManager);

        controller.loadAll(); // Carrega dados dos ficheiros

        while (true) {
            System.out.println("\n--- GESTÃO DE STOCKS ---");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Criar Produto");
            System.out.println("3. Listar Prateleiras");
            System.out.println("4. Criar Prateleira");
            System.out.println("5. Guardar Dados");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    controller.listProducts();
                    break;
                case "2":
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(sc.nextLine());
                    System.out.print("Tem IVA? (true/false): ");
                    boolean temIVA = Boolean.parseBoolean(sc.nextLine());
                    controller.createProduct(nome, preco, temIVA);
                    break;
                case "3":
                    controller.listShelves();
                    break;
                case "4":
                    System.out.print("Localização: ");
                    String local = sc.nextLine();
                    System.out.print("Capacidade: ");
                    int capacidade = Integer.parseInt(sc.nextLine());
                    System.out.print("Preço diário: ");
                    double precoDia = Double.parseDouble(sc.nextLine());
                    // Aqui por agora não associamos produto, só null
                    controller.createShelf(local, capacidade, precoDia, null);
                    break;
                case "5":
                    controller.saveAll();
                    System.out.println("Dados guardados com sucesso!");
                    break;
                case "6":
                    System.out.println("A sair...");
                    controller.saveAll();
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
