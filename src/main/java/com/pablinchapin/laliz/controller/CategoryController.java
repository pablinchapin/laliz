/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.controller;

import com.pablinchapin.laliz.model.Category;
import com.pablinchapin.laliz.service.CategoryService;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    
    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Category> gettCategories(){
        return categoryService.getAllCategories();
    }
    
    
    
}
