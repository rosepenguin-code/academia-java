package io.altar.jseproject.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import io.altar.jseproject.dtos.ShelfDTO;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

@Stateless
public class ShelfManager {

    @Inject
    private ShelfRepository repository;

    @SuppressWarnings("cdi-ambiguous-dependency")
    @Inject
    private ProductManager productManager; // para buscar produtos existentes

    // Criar shelf
    public long create(Shelf shelf) {
        return repository.create(shelf);
    }

    // Encontrar shelf por id
    public Shelf findById(long id) {
        return repository.findById(id);
    }

    // Ler todas as shelves
    public List<Shelf> readAll() {
        return repository.findAll();
    }

    // Atualizar shelf
    public Shelf update(Shelf shelf) {
        return repository.update(shelf);
    }

    // Apagar shelf
    public void delete(long id) {
        repository.delete(id);
    }

    // Limpar produto de todas as shelves
    public void clearProductFromShelves(long productId) {
        repository.clearProductFromShelves(productId);
    }

    // Converter DTO para entidade
    public Shelf fromDTO(ShelfDTO dto) {
        Product product = null;
        if (dto.getProdutoId() != null) {
            product = productManager.findById(dto.getProdutoId());
            if (product == null) {
                throw new IllegalArgumentException("Produto com id " + dto.getProdutoId() + " não existe.");
            }
        }

        Shelf shelf = new Shelf(dto.getLocalizacao(), dto.getCapacidade(), dto.getPrecoDiario(), product);

        // Se dto.getId() > 0, define o id (para update)
        if (dto.getId() > 0) {
            shelf.setId(dto.getId());
        }

        return shelf;
    }
}
