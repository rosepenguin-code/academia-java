package io.altar.jseproject.business;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ShelfRepository;

import java.util.List;

public class ShelfManager {
    private final ShelfRepository repository = ShelfRepository.getInstance();

    public void createShelf(String localizacao, int capacidade, double precoDiario, Product produto) {
        Shelf s = new Shelf(localizacao, capacidade, precoDiario);
        s.setProduto(produto);
        repository.create(s);
        System.out.println("Prateleira criada: " + s);
    }

    public void listShelves() {
        List<Shelf> prateleiras = repository.readAll();
        if (prateleiras.isEmpty()) {
            System.out.println("Nenhuma prateleira disponível.");
        } else {
            prateleiras.forEach(System.out::println);
        }
    }

    public void saveShelves() {
        repository.saveToFile();
    }

    public void loadShelves(List<Product> produtos) {
        repository.loadFromFile(produtos);
    }
}
