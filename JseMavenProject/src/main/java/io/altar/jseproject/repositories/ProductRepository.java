package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductRepository {

    @PersistenceContext(unitName = "stockPU")
    private EntityManager em;

    public long create(Product product) {
        em.persist(product);
        return product.getId();
    }

    public Product findById(long id) {
        return em.find(Product.class, id); // Product.class deve ser a tua entidade correta
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public Product update(Product product) {
        return em.merge(product);
    }

    public void delete(long id) {
        Product p = em.find(Product.class, id);
        if (p != null) {
            em.remove(p);
        }
    }

    public List<Long> getShelfIdsByProductId(long productId) {
        return em.createQuery(
                "SELECT s.id FROM Shelf s WHERE s.product.id = :pid", Long.class)
                .setParameter("pid", productId)
                .getResultList();
    }

    // Métodos adicionais consistentes
    public List<Product> readAll() {
        return findAll();
    }

    public Optional<Product> readById(long id) {
        return Optional.ofNullable(findById(id));
    }
}
