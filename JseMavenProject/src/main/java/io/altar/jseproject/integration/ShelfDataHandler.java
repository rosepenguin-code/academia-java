package io.altar.jseproject.integration;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShelfDataHandler {
    private final String file = "shelves.csv";

    public List<Shelf> loadShelves(Map<Long, Product> productMap) {
        List<Shelf> shelves = new ArrayList<>();
        File f = new File(file);
        if (!f.exists()) return shelves;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                Shelf s = new Shelf(
                    parts[1],                         // localizacao
                    Integer.parseInt(parts[2]),       // capacidade
                    Double.parseDouble(parts[4])      // precoDiario
                    , null
                );
                s.setId(Long.parseLong(parts[0]));

                // Associa o produto se existir
                Long productId = parts[3].equals("null") ? null : Long.parseLong(parts[3]);
                if (productId != null && productMap.containsKey(productId)) {
                    s.setProduct(productMap.get(productId));
                }

                shelves.add(s);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler prateleiras: " + e.getMessage());
        }

        return shelves;
    }

    public void saveShelves(List<Shelf> shelves) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Shelf s : shelves) {
                String productId = (s.getProduct() != null) ? String.valueOf(s.getProduct().getId()) : "null";
                bw.write(s.getId() + ";" + s.getLocalizacao() + ";" + s.getCapacidade() + ";" + productId + ";" + s.getPrecoDiario());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao guardar prateleiras: " + e.getMessage());
        }
    }
}
