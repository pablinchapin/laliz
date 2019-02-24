/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.laliz.service;

import com.pablinchapin.laliz.exception.ResourceNotFoundException;
import com.pablinchapin.laliz.model.Order;
import com.pablinchapin.laliz.repository.OrderRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pvargas
 */

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    
    public Order getOrder(Long id){
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order id not found"));
    }
    
    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository
                .findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        
        return orderRepository
                .save(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }
    
}
