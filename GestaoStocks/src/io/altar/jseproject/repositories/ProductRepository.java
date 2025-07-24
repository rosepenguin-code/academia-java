package io.altar.jseproject.repositories;

import java.util.List;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.interfaces.ProductRepositoryCRUD_Interface;

public class ProductRepository extends EntityRepository<Product> implements ProductRepositoryCRUD_Interface {

    private static final ProductRepository INSTANCE = new ProductRepository();

    private ProductRepository() {}

    public static ProductRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Long> getShelfIdsByProductId(long productId) {
        
        return null;
    }
}
