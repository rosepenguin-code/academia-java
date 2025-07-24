package io.altar.jseproject.repositories.interfaces;

import java.util.List;
import io.altar.jseproject.model.Product;

public interface ProductRepositoryCRUD_Interface extends EntityRepositoryCRUD_Interface<Product> {
    List<Long> getShelfIdsByProductId(long productId);
}
