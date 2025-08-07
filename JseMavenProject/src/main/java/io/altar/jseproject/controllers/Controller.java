
package io.altar.jseproject.controllers;

import io.altar.jseproject.business.ProductManager;
import io.altar.jseproject.business.ShelfManager;
import io.altar.jseproject.model.Product;

import java.util.List;

public class Controller {

    private final ProductManager productManager;
    private final ShelfManager shelfManager;

    public Controller(ProductManager productManager, ShelfManager shelfManager) {
        this.productManager = productManager;
        this.shelfManager = shelfManager;
    }

    public void createProduct(String nome, double preco, boolean temIVA) {
        productManager.create(nome, preco, temIVA);
    }

    public void listProducts() {
        productManager.readAll();
    }

    public void createShelf(String localizacao, int capacidade, double precoDiario, Product produto) {
        shelfManager.createShelf(localizacao, capacidade, precoDiario, produto);
    }

    public void listShelves() {
        shelfManager.readAll();
    }

    public void saveAll() {
        productManager.saveProducts();
        shelfManager.saveShelves();
    }

    public void loadAll() {
        List<Product> produtos = productManager.loadProducts();
        shelfManager.loadShelves(produtos);
    }
}
