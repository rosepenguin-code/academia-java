package io.altar.jseproject.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.altar.jseproject.model.Entity_;

public abstract class EntityRepository<T extends Entity_> {

    protected List<T> entities = new ArrayList<>();
    private static long currentId = 1;

    // Método para gerar IDs únicos
    protected long getNextId() {
        return currentId++;
    }

    // Criar entidade (adicionar e atribuir id se for zero)
    public long create(T entity) {
    	if (entity.getId() <= 0) {
            entity.setId(getNextId());
        }
        entities.add(entity);
        return entity.getId();
    }

    // Atualizar entidade
    public void update(T entity) {
        int index = findIndexById(entity.getId());
        if (index != -1) {
            entities.set(index, entity);
        }
    }

    // Apagar entidade pelo ID
    public void delete(long id) {
        int index = findIndexById(id);
        if (index != -1) {
            entities.remove(index);
        }
    }

    // Encontrar índice pelo ID
    private int findIndexById(long id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // Listar todas as entidades
    public List<T> readAll() {
        return new ArrayList<>(entities);
    }

    // Encontrar entidade por ID com Optional
    public Optional<T> readById(long id) {
        for (T entity : entities) {
            if (entity.getId() == id) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    // Obter todos os IDs
    public List<Long> getAllIds() {
        return entities.stream()
            .map(Entity_::getId)
            .collect(Collectors.toList());
    }

    public boolean isEmpty() {
        return entities.isEmpty();
    }
}
