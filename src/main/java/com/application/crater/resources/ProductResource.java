package com.application.crater.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.crater.dtos.request.CreateProductRequest;
import com.application.crater.dtos.response.CreateProductResponse;
import com.application.crater.entities.Product;
import com.application.crater.mappers.ProductMapper;
import com.application.crater.services.CreateProductService;

@RestController
@RequestMapping(value = "/produto")
public class ProductResource {

	@Autowired
	private CreateProductService createProduct;

	@PostMapping
	public ResponseEntity<CreateProductResponse> create(@RequestBody CreateProductRequest request) {

		Product obj = ProductMapper.createEntityFromRequestDTO(request);

		obj = createProduct.execute(obj);

		CreateProductResponse response = ProductMapper.createResponseDTOFromEntity(obj);

		return ResponseEntity.created(null).body(response);
	}
}
