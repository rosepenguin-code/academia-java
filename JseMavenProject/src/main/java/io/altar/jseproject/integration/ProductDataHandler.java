package io.altar.jseproject.integration;

import io.altar.jseproject.model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDataHandler {
    private final String file = "products.csv";

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        File f = new File(file);
        if (!f.exists()) return products;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                Product p = new Product(
                    parts[1],
                    Double.parseDouble(parts[2]),
                    Boolean.parseBoolean(parts[3])
                );
                p.setId(Long.parseLong(parts[0]));
                products.add(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler produtos: " + e.getMessage());
        }
        return products;
    }

    public void saveProducts(List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Product p : products) {
                bw.write(p.getId() + ";" + p.getNome() + ";" + p.getPreco() + ";" + p.isTemIVA());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao guardar produtos: " + e.getMessage());
        }
    }
}
