package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Shelf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class ShelfRepository {

    @PersistenceContext(unitName = "stockPU")
    private EntityManager em;

    public long create(Shelf shelf) {
        em.persist(shelf);
        return shelf.getId();
    }

    public Shelf findById(long id) {
        return em.find(Shelf.class, id);
    }

    public List<Shelf> findAll() {
        return em.createQuery("SELECT s FROM Shelf s", Shelf.class).getResultList();
    }

    public Shelf update(Shelf shelf) {
        return em.merge(shelf);
    }

    public void delete(long id) {
        Shelf s = em.find(Shelf.class, id);
        if (s != null) {
            em.remove(s);
        }
    }

    public void clearProductFromShelves(long productId) {
        List<Shelf> shelves = findAll();
        for (Shelf s : shelves) {
            if (s.getProduct() != null && s.getProduct().getId() == productId) {
                s.setProduct(null);
                update(s);
            }
        }
    }

    public List<Shelf> readAll() {
        return findAll();
    }

    public Optional<Shelf> readById(long id) {
        return Optional.ofNullable(findById(id));
    }
}
