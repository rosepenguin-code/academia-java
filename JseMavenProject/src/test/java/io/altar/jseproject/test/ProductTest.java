package io.altar.jseproject.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.altar.jseproject.model.Product;

public class ProductTest {

    @Test
    public void testSetDiscountAbove100ShouldThrowException() {
        Product product = new Product(null, 0, false);
        assertThrows(RuntimeException.class, () -> {
            product.setDiscount(1.5); // 150%
        });
    }

    @Test
    public void testSetDiscountBelow0ShouldThrowException() {
        Product product = new Product(null, 0, false);
        assertThrows(RuntimeException.class, () -> {
            product.setDiscount(-0.1); // -10%
        });
    }

    @Test
    public void testSetValidDiscount() {
        Product product = new Product(null, 0, false);
        assertDoesNotThrow(() -> {
            product.setDiscount(0.25); // 25%
        });
    }
}
