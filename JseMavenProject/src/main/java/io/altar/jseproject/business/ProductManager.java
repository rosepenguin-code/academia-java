package io.altar.jseproject.business;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductManager extends EntityManager<Product> {

    @Inject
    ProductRepository repository;

    @Inject
    ShelfRepository shelfRepo;

    @Override
    public long create(Product entity) {
        return repository.create(entity);
    }

    @Override
    public List<Product> readAll() {
        return repository.readAll();
    }

    @Override
    public Optional<Product> readById(long id) {
        return repository.readById(id);
    }

    @Override
    public void update(Product entity) {
        repository.update(entity);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
        for (Shelf shelf : shelfRepo.readAll()) {
            if (shelf.getProduto() != null && shelf.getProduto().getId() == id) {
                shelf.setProduto(null);
                shelfRepo.update(shelf);
            }
        }
    }
}
