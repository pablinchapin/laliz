/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.service;

import com.pablinchapin.laliz.exception.ResourceNotFoundException;
import com.pablinchapin.laliz.model.Category;
import com.pablinchapin.laliz.model.Product;
import com.pablinchapin.laliz.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pvargas
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
        
    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> getAllProductsByCategoryId(Long categoryId) {
    
        //Long categoryId = category.getId();
        return productRepository
                .findByCategoryId(categoryId);
    }

    @Override
    public Product getProduct(Long id){
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository
                .save(product);
    }

    
    
}
