/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.repository;

import com.pablinchapin.laliz.model.OrderProduct;
import com.pablinchapin.laliz.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pvargas
 */
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK>{
    
}
