package com.example.order.payment;

public interface PaymentGatewayClient {
    void processPayment(Long orderId);
}
