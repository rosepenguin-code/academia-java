package io.altar.jseproject.repositories.interfaces;

import java.util.List;
import java.util.Optional;

public interface EntityRepositoryCRUD_Interface<T> {
    Optional<T> readById(long id);
    List<T> readAll();
    long create(T entity);
    void update(T entity);
    void delete(long id);
    List<Long> getAllIds();
}
