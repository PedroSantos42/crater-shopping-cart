package com.application.crater.mappers;

import com.application.crater.dtos.request.CreateProductRequest;
import com.application.crater.dtos.response.CreateProductResponse;
import com.application.crater.entities.Category;
import com.application.crater.entities.Product;

public class ProductMapper {

	public static Product createEntityFromRequestDTO(CreateProductRequest dto) {
		return new Product(null, dto.getName(), dto.getPrice(), dto.getQuantity(),
				new Category(null, dto.getCategory()));
	}

	public static CreateProductRequest createRequestDTOFromEntity(Product obj) {
		return new CreateProductRequest(obj.getName(), obj.getPrice(), obj.getQuantity(), obj.getCategory().getName());
	}

	public static CreateProductResponse createResponseDTOFromEntity(Product obj) {
		return new CreateProductResponse(obj.getId(), obj.getName(), obj.getPrice(), obj.getQuantity(),
				obj.getCategory().getName());
	}
}
