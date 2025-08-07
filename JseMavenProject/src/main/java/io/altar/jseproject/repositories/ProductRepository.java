package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.interfaces.ProductRepositoryCRUD_Interface;
import io.altar.jseproject.integration.ProductDataHandler;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProductRepository extends EntityRepository<Product> implements ProductRepositoryCRUD_Interface {

    private final ProductDataHandler dataHandler = new ProductDataHandler();

    @Override
    public List<Long> getShelfIdsByProductId(long productId) {
        // Placeholder, como tinhas
        return null;
    }

    public void saveToFile() {
        dataHandler.saveProducts(entities);
    }

    public void loadFromFile() {
        entities = dataHandler.loadProducts();
    }
}
