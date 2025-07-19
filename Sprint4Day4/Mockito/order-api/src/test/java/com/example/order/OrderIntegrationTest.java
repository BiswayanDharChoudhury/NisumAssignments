package com.example.order;

import com.example.order.entity.Order;
import com.example.order.payment.PaymentGatewayClient;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PaymentGatewayClient paymentGatewayClient;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void placeOrder_invokesGateway_andWiresBeans() {
        String desc = "test order";
        Order newOrder = new Order();
        newOrder.setDescription(desc);

        ResponseEntity<Order> response = restTemplate.postForEntity("/orders", newOrder, Order.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Order body = response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getDescription()).isEqualTo(desc);

        verify(paymentGatewayClient, times(1)).processPayment(body.getId());
        assertThat(orderService).isNotNull();
        assertThat(orderRepository).isNotNull();
    }
}
