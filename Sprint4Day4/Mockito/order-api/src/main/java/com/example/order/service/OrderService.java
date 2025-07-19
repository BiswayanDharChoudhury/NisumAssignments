package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.payment.PaymentGatewayClient;
import com.example.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentGatewayClient paymentGatewayClient;

    public OrderService(OrderRepository orderRepository, PaymentGatewayClient paymentGatewayClient) {
        this.orderRepository = orderRepository;
        this.paymentGatewayClient = paymentGatewayClient;
    }

    @Transactional
    public Order placeOrder(String description) {
        Order order = orderRepository.save(new Order(description));
        paymentGatewayClient.processPayment(order.getId());
        return order;
    }
}
