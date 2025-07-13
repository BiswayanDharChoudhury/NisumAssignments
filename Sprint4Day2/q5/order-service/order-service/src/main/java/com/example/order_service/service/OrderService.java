package com.example.order_service.service;

import com.example.order_service.model.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    public List<Order> getAllOrders() {
        // Example static data
        return Arrays.asList(
                new Order(1L, "Order 1"),
                new Order(2L, "Order 2")
        );
    }
}
