package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Value("${feature.enableOrderTracking:true}")
    private boolean enableOrderTracking;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/feature-flag")
    public boolean isOrderTrackingEnabled() {
        return enableOrderTracking;
    }
}
