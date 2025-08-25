package io.altar.jseproject.business;

import java.util.List;
import java.util.Optional;



import io.altar.jseproject.model.Entity_;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityService<R extends EntityRepository<E>, E extends Entity_> {

   
    protected R repository;

    // Criar
    public long create(E entity) {
        return repository.create(entity);
    }

    // Atualizar
    public void update(E entity) {
        repository.update(entity);
    }

    // Apagar
    public void delete(long id) {
        repository.delete(id);
    }

    // Ler todos
    public List<E> readAll() {
        return repository.readAll();
    }

    // Ler por ID
    public Optional<E> readById(long id) {
        return repository.readById(id);
    }

    // Verifica se está vazio
    public boolean isEmpty() {
        return repository.isEmpty();
    }

    // Obter todos os IDs
    public List<Long> getAllIds() {
        return repository.getAllIds();
    }

	protected abstract Product findById(Long produtoId);
}
