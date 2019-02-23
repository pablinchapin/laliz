/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.service;

import com.pablinchapin.laliz.model.Category;
import com.pablinchapin.laliz.model.Product;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author pvargas
 */

@Validated
public interface ProductService {
    
    @NotNull
    Iterable<Product> getAllProducts();
    
    @NotNull
    Iterable<Product> getAllProductsByCategoryId(Long categoryId);
    
    Product getProduct(@Min(value = 1L, message = "Invalid product ID") Long id);
    
    Product save(Product product);
    
}
