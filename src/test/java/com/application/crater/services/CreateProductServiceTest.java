package com.application.crater.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.application.crater.entities.Product;
import com.application.crater.repositories.ProductRepository;


@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CreateProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private CreateProductService createProduct;

    private Product product;

    @BeforeAll
    public void setUp() {
        this.product = mockProduct();
    }

    @Test
    public void givenProductWithValidArgs_persistEntityInDatabase_thenReturnCreatedInstance() {
        given(repository.save(product)).willReturn(product);

        Product result = createProduct.execute(product);

        then(repository).should(times(1)).save(product);
        assertNotNull(result);
    }

    private Product mockProduct() {
        Product mockedProduct = new Product();

        mockedProduct.setId(1);
        mockedProduct.setPrice(42.99);
        mockedProduct.setQuantity(20);
        mockedProduct.setName("PRODUCT-MOCK");

        return mockedProduct;
    }
}