package com.application.crater.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.crater.dtos.request.CreateProductRequest;
import com.application.crater.dtos.response.CreateProductResponse;
import com.application.crater.entities.Category;
import com.application.crater.entities.Product;
import com.application.crater.mappers.ProductMapper;
import com.application.crater.services.CreateCategoryService;
import com.application.crater.services.CreateProductService;
import com.application.crater.services.ListCategoryService;

@RestController
@RequestMapping(value = "/produto")
public class ProductResource {

	@Autowired
	private CreateProductService createProduct;

	@Autowired
	private CreateCategoryService createCategory;

	@Autowired
	private ListCategoryService listCategory;

	@PostMapping
	public ResponseEntity<CreateProductResponse> create(@RequestBody CreateProductRequest request) {

		Product product = ProductMapper.createEntityFromRequestDTO(request);

		Category category = createCategoryIfNotExists(request.getCategory());

		product.setCategory(category);

		product = createProduct.execute(product);

		CreateProductResponse response = ProductMapper.createResponseDTOFromEntity(product);

		return ResponseEntity.created(null).body(response);
	}

	private Category createCategoryIfNotExists(String categoryName) {
		Optional<Category> category;

		category = listCategory.findByName(categoryName);

		if (category.isPresent()) {
			return category.get();
		}

		Category createdCategory = createCategory.execute(new Category(null, categoryName));

		return createdCategory;
	}
}
