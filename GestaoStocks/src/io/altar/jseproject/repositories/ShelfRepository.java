package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.interfaces.ShelfRepositoryCRUD_Interface;

public class ShelfRepository extends EntityRepository<Shelf> implements ShelfRepositoryCRUD_Interface {
    private static final ShelfRepository INSTANCE = new ShelfRepository();

    private ShelfRepository() {
    }

    public static ShelfRepository getInstance() {
        return INSTANCE;
    }
}
