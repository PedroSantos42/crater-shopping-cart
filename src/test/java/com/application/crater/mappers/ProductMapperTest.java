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
import com.application.crater.entities.Category;
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
		assertEquals(requestDTO.getCategory(), product.getCategory().getName());
	}

	@Test
	public void givenProductEntity_mapToRequest_thenReturnCreatedDTO() {
		Product product = mockProduct();

		CreateProductRequest requestDTO = ProductMapper.createRequestDTOFromEntity(product);

		assertEquals(requestDTO.getName(), product.getName());
		assertEquals(requestDTO.getPrice(), product.getPrice());
		assertEquals(requestDTO.getQuantity(), product.getQuantity());
		assertEquals(requestDTO.getCategory(), product.getCategory().getName());
	}

	@Test
	public void givenProductEntity_mapToResponse_thenReturnCreatedDTO() {
		Product product = mockProduct();

		CreateProductResponse responseDTO = ProductMapper.createResponseDTOFromEntity(product);

		assertEquals(responseDTO.getName(), product.getName());
		assertEquals(responseDTO.getPrice(), product.getPrice());
		assertEquals(responseDTO.getQuantity(), product.getQuantity());
		assertEquals(responseDTO.getCategory(), product.getCategory().getName());
	}

	private CreateProductRequest mockRequest() {
		CreateProductRequest request = new CreateProductRequest();

		request.setName("Computador");
		request.setPrice(2500.0);
		request.setQuantity(5);

		return request;
	}

	private Product mockProduct() {
		Product product = new Product();

		product.setId(null);
		product.setName("Computador");
		product.setPrice(2500.0);
		product.setQuantity(5);
		product.setCategory(new Category(null, "Tecnologia"));

		return product;
	}
}
