/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.service;

import com.pablinchapin.laliz.exception.ResourceNotFoundException;
import com.pablinchapin.laliz.model.Category;
import com.pablinchapin.laliz.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;

/**
 *
 * @author pvargas
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    
    @Override
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    
}
