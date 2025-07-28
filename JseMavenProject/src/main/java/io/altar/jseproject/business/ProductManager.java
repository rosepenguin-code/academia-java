package io.altar.jseproject.business;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

import java.util.List;

public class ProductManager {
    private final ProductRepository repository = ProductRepository.getInstance();

    public void createProduct(String nome, double preco, boolean temIVA) {
        Product p = new Product(nome, preco, temIVA);
        repository.create(p);
        System.out.println("Produto criado: " + p);
    }

    public void listProducts() {
        List<Product> produtos = repository.readAll();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    public void saveProducts() {
        repository.saveToFile();
    }

    public List<Product> loadProducts() {
        repository.loadFromFile();
        return repository.readAll();
    }
}
