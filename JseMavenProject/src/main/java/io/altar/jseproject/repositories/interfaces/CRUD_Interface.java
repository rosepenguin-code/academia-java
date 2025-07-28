package io.altar.jseproject.repositories.interfaces;

import java.util.List;

public interface CRUD_Interface<T> {
    long create(T entity);
    List<T> readAll();
    T readById(long id);
    void update(T entity);
    void delete(long id);
}
