package com.example.app.category.controllers;

import com.example.app.category.entities.Category;
import com.example.app.category.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("categories")
    public Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("categories/{categoryId}")
    public Optional<Category> getCategoryById(@PathVariable Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("categories")
    public void addCategory(@RequestBody Category theCategory) {
        categoryService.addCategory(theCategory);
    }

    @PutMapping("categories/{categoryId}")
    public void updateCategoryById(@RequestBody Category theCategory, @PathVariable Integer categoryId) {
        categoryService.updateCategoryById(theCategory, categoryId);
    }

    @DeleteMapping("categories/{categoryId}")
    public void deleteCategoryById(@PathVariable Integer categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }

}
