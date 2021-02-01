package com.application.crater.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.crater.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Optional<Category> findByName(String name);
}
