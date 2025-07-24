package io.altar.jseproject.textinterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- GESTÃO DE STOCKS ---");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Criar Produto");
            System.out.println("3. Editar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("5. Listar Prateleiras");
            System.out.println("6. Criar Prateleira");
            System.out.println("7. Editar Prateleira");
            System.out.println("8. Remover Prateleira");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    GestorProdutos.listarProdutos(sc);
                    break;
                case "2":
                    GestorProdutos.criarProduto(sc);
                    break;
                case "3":
                    GestorProdutos.editarProduto(sc);
                    break;
                case "4":
                    GestorProdutos.removerProduto(sc);
                    break;
                case "5":
                    GestorPrateleiras.listarPrateleiras(sc);
                    break;
                case "6":
                    GestorPrateleiras.criarPrateleira(sc);
                    break;
                case "7":
                    GestorPrateleiras.editarPrateleira(sc);
                    break;
                case "8":
                    GestorPrateleiras.removerPrateleira(sc);
                    break;
                case "9":
                    System.out.println("A sair...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

