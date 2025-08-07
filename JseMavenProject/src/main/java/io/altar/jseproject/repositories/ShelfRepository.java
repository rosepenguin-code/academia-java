package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.interfaces.ShelfRepositoryCRUD_Interface;
import io.altar.jseproject.integration.ShelfDataHandler;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf> implements ShelfRepositoryCRUD_Interface {

    private final ShelfDataHandler dataHandler = new ShelfDataHandler();

    public void saveToFile() {
        dataHandler.saveShelves(entities);
    }

    public void loadFromFile(List<Product> products) {
        Map<Long, Product> productMap = new HashMap<>();
        for (Product p : products) {
            productMap.put(p.getId(), p);
        }
        entities = dataHandler.loadShelves(productMap);
    }
}
