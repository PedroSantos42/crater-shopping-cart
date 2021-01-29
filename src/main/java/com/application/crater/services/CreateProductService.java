package com.application.crater.services;

import com.application.crater.entities.Product;
import com.application.crater.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

    @Autowired
    private ProductRepository repository;

    public Product execute(Product obj) {
        Product product = repository.save(obj);

        return product;
    }
}
