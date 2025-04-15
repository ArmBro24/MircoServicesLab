package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceInt service;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody Order order) {
        Order created = service.createOrder(order);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        List<Order> list = service.getAllOrders();
        return list.isEmpty()
                ? ResponseEntity.badRequest().body("⚠ No orders found.")
                : ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long id) {
        return service.getOrderById(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body("❌ Order not found."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.ok("✅ Order deleted.");
    }
}
