/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.controller;

import com.pablinchapin.laliz.model.Product;
import com.pablinchapin.laliz.service.ProductService;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    
    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }
    
    
    @GetMapping(value = {"/byCategory/{categoryId}"})
    public @NotNull Iterable<Product> getProductsByCategory(
            @PathVariable Long categoryId
    ){
        return productService.getAllProductsByCategoryId(categoryId);
    }
}
