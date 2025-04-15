package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "\"orderslab\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;


    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @Column(name = "price")
    private BigDecimal price;
}
