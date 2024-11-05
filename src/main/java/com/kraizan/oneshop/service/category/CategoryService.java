package com.kraizan.oneshop.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kraizan.oneshop.exceptions.AlreadyExistsException;
import com.kraizan.oneshop.exceptions.ResourceNotFoundExpception;
import com.kraizan.oneshop.model.Category;
import com.kraizan.oneshop.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpception("Category not found!"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository::save)
                .orElseThrow(() -> new AlreadyExistsException(category + " already exists!"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        }).orElseThrow(() -> new ResourceNotFoundExpception("Category not found!"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete, () -> {
            throw new ResourceNotFoundExpception("Category not found!");
        });
    }

}
