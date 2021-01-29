package com.application.crater.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.application.crater.dtos.request.CreateProductRequest;
import com.application.crater.dtos.response.CreateProductResponse;
import com.application.crater.entities.Product;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ProductMapperTest {
	
	@Test
	public void givenCallToConstructor_returnCreatedInstance() {
		ProductMapper mapper = new ProductMapper();
		
		assertNotNull(mapper);
	}

	@Test
	public void givenRequestDTO_mapToEntity_thenReturnCreatedInstance() {
		CreateProductRequest requestDTO = mockRequest();

		Product product = ProductMapper.createEntityFromRequestDTO(requestDTO);

		assertEquals(requestDTO.getName(), product.getName());
		assertEquals(requestDTO.getPrice(), product.getPrice());
		assertEquals(requestDTO.getQuantity(), product.getQuantity());
	}

	@Test
	public void givenProductEntity_mapToRequest_thenReturnCreatedDTO() {
		Product product = mockProduct();

		CreateProductRequest requestDTO = ProductMapper.createRequestFromEntity(product);

		assertEquals(requestDTO.getName(), product.getName());
		assertEquals(requestDTO.getPrice(), product.getPrice());
		assertEquals(requestDTO.getQuantity(), product.getQuantity());
	}

	@Test
	public void givenProductEntity_mapToResponse_thenReturnCreatedDTO() {
		Product product = mockProduct();

		CreateProductResponse responseDTO = ProductMapper.createResponseFromEntity(product);

		assertEquals(responseDTO.getName(), product.getName());
		assertEquals(responseDTO.getPrice(), product.getPrice());
		assertEquals(responseDTO.getQuantity(), product.getQuantity());
	}

	private CreateProductRequest mockRequest() {
		return new CreateProductRequest("Computador", 2500.0, 5);
	}

	private Product mockProduct() {
		return new Product(null, "Computador", 2500.0, 5);
	}
}
