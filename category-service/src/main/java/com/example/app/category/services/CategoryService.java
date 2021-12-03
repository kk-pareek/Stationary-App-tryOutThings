package com.example.app.category.services;

import com.example.app.category.entities.Category;
import com.example.app.category.exceptions.CategoryNotFoundException;
import com.example.app.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer categoryId) {
        Optional<Category> theCategory = categoryRepository.findById(categoryId);
        if(theCategory.isPresent())
            return theCategory;
        else
            throw new CategoryNotFoundException("Category with id: '"+categoryId+"' does not exist.");
    }

    public void addCategory(Category theCategory) {
        categoryRepository.save(theCategory);
    }

    public void updateCategoryById(Category theCategory, Integer categoryId) {
        Category existingCategory = getCategoryById(categoryId).get();
        existingCategory.setCategoryName(theCategory.getCategoryName());
        existingCategory.setCategoryDescription(theCategory.getCategoryDescription());
        categoryRepository.save(existingCategory);
    }

    public void deleteCategoryById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
