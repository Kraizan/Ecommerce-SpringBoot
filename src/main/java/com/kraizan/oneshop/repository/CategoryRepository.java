package com.kraizan.oneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kraizan.oneshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
