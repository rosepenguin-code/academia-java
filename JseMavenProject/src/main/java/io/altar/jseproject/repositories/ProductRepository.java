package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.interfaces.ProductRepositoryCRUD_Interface;
import io.altar.jseproject.integration.ProductDataHandler;

import java.util.List;

public class ProductRepository extends EntityRepository<Product> implements ProductRepositoryCRUD_Interface {

    private static final ProductRepository INSTANCE = new ProductRepository();
    private final ProductDataHandler dataHandler = new ProductDataHandler();

    private ProductRepository() {}

    public static ProductRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Long> getShelfIdsByProductId(long productId) {
        // Podes implementar isto depois com ligação às shelves
        return null;
    }

    public void saveToFile() {
        dataHandler.saveProducts(entities);
    }

    public void loadFromFile() {
        entities = dataHandler.loadProducts();
    }
}
