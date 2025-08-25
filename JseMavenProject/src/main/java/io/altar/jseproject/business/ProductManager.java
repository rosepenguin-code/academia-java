package io.altar.jseproject.business;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductManager {

    @Inject
    private ProductRepository repository;

    public long create(Product product) {
        return repository.create(product);
    }

    public Product findById(long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // evita o crash do controller
        }
    }


    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product update(Product product) {
        return repository.update(product);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public List<Long> getShelfIdsByProductId(long productId) {
        return repository.getShelfIdsByProductId(productId);
    }

    public List<Product> readAll() {
        return repository.readAll();
    }

    public Optional<Product> readByIdOptional(long id) {
        return repository.readById(id);
    }
}
