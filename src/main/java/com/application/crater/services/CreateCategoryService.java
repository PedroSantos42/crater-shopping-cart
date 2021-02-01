package com.application.crater.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.crater.entities.Category;
import com.application.crater.repositories.CategoryRepository;

@Service
public class CreateCategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category execute(Category obj) {
		Category category = repository.save(obj);

        return category;
    }
}
