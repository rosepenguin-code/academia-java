package io.altar.jseproject.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.altar.jseproject.model.Product;

public class TextInterfaceTest {

	@Test
	@DisplayName("Test set product id")
	void testSetProductId() {
		Product p = new Product(null, 0, false);
		assertEquals(-1, p.getId(), "Default ID should be -1");
		assertDoesNotThrow(() -> p.setId(1));
	}

	@Test
	@DisplayName("Test set product id with invalid id")
	void testSetProductIdWithInvalidId() {
		Product p = new Product(null, 0, false);
		assertThrows(RuntimeException.class, () -> p.setId(-2));
	}

	@Test
	void testSetProductIdAfterValidId() {
		Product p = new Product(null, 0, false);
		p.setId(1);
		assertThrows(RuntimeException.class, () -> p.setId(2));
		assertThrows(RuntimeException.class, () -> p.setId(-2));
	}
}
