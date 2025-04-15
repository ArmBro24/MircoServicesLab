package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderServiceInt {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    void deleteOrder(Long id);
}
