package io.altar.jseproject.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.altar.jseproject.model.Product;

public class ProductModelTest {

    @Test
    @DisplayName("Test default ID")
    void testDefaultId() {
        Product p = new Product(null, 0, false);
        assertEquals(0, p.getId(), "O ID por defeito deve ser 0");
    }

    @Test
    @DisplayName("Test set valid product ID")
    void testSetProductId() {
        Product p = new Product(null, 0, false);
        assertDoesNotThrow(() -> p.setId(1));
        assertEquals(1, p.getId());
    }

    @Test
    @DisplayName("Test set negative product ID")
    void testSetProductIdWithNegativeId() {
        Product p = new Product(null, 0, false);
        // Como já não lançamos exceção, testamos que o ID muda
        p.setId(-2);
        assertEquals(-2, p.getId());
    }

    @Test
    @DisplayName("Test overriding product ID")
    void testOverrideProductId() {
        Product p = new Product(null, 0, false);
        p.setId(1);
        p.setId(2);
        assertEquals(2, p.getId());
    }
}
