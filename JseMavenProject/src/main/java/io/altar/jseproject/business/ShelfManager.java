package io.altar.jseproject.business;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.repositories.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ShelfManager extends EntityManager<Shelf> {

    @Inject
    ShelfRepository repository;

    @Inject
    ProductRepository productRepo;

    @Override
    public long create(Shelf shelf) {
        if (shelf.getProduto() != null && shelf.getProduto().getId() > 0) {
            Optional<Product> produto = productRepo.readById(shelf.getProduto().getId());
            produto.ifPresent(shelf::setProduto);
        }
        return repository.create(shelf);
    }

    @Override
    public List<Shelf> readAll() {
        return repository.readAll();
    }

    @Override
    public Optional<Shelf> readById(long id) {
        return repository.readById(id);
    }

    @Override
    public void update(Shelf shelf) {
        if (shelf.getProduto() != null && shelf.getProduto().getId() > 0) {
            Optional<Product> produto = productRepo.readById(shelf.getProduto().getId());
            produto.ifPresent(shelf::setProduto);
        }
        repository.update(shelf);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
