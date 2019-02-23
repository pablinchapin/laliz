/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.repository;

import com.pablinchapin.laliz.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pvargas
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{
    
}
