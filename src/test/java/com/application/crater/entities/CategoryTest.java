package com.application.crater.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CategoryTest {

	@Test
	public void givenValidArgs_createCategoryObject() {
		int id = 1;
		String name = "Tecnologia";

		Category category = new Category();
		category = new Category(id, name);

		category.setId(id);
		category.setName(name);

		assertEquals(category.getId(), id);
		assertEquals(category.getName(), name);
	}
}
