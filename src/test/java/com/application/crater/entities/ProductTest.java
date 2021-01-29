package com.application.crater.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ProductTest {

	@Test
	public void givenValidArgs_createProductObject() {
		int id = 1;
		double price = 9.90;
		String name = "NOME-PRODUTO";
		int quantity = 10;

		Product product = new Product();
		product = new Product(id, name, price, quantity);
		product.setId(id);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setName(name);

		assertEquals(product.getId(), id);
		assertEquals(product.getName(), name);
		assertEquals(product.getPrice(), price);
		assertEquals(product.getQuantity(), quantity);
	}
}
