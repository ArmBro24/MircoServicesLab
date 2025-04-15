package com.example.demo.service.impl;

import com.example.demo.DTO.UserDTO;
import com.example.demo.client.UserClientInt;
import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderServiceInt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceIntImpl implements OrderServiceInt {

    private final OrderRepository repository;
    private final UserClientInt userClient;

    @Override
    public Order createOrder(Order order) {
        UserDTO user = userClient.getUserById(order.getUserId());

        log.info("👤 Fetched user: {}", user.getUsername());

        return repository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
