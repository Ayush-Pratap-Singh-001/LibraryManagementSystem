package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public Category saveOrUpdate(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }
}