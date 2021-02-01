package com.application.crater.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.crater.entities.Category;
import com.application.crater.repositories.CategoryRepository;

@Service
public class ListCategoryService {

	@Autowired
	private CategoryRepository repository;

	public Optional<Category> findByName(String name) {
		Optional<Category> result = repository.findByName(name);

		return result;
	}
}
