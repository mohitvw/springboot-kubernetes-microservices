package com.ecommerce.order.service;

import com.ecommerce.order.client.PaymentClient;
import com.ecommerce.order.client.ProductClient;
import com.ecommerce.order.dto.OrderRequest;
import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final PaymentClient paymentClient;

    public OrderService(
            OrderRepository orderRepository,
            ProductClient productClient,
            PaymentClient paymentClient) {

        this.orderRepository = orderRepository;
        this.productClient = productClient;
        this.paymentClient = paymentClient;
    }

    public OrderResponse createOrder(OrderRequest request) {

        if (!productClient.productExists(request.productId())) {
            throw new IllegalArgumentException(
                    "Product not found: " + request.productId()
            );
        }

        boolean paymentSuccessful = paymentClient.processPayment();

        if (!paymentSuccessful) {
            throw new IllegalStateException("Payment failed");
        }

        Order order = new Order(
                request.productId(),
                request.quantity(),
                request.amount(),
                "CONFIRMED"
        );

        Order savedOrder = orderRepository.save(order);

        return OrderResponse.from(savedOrder);
    }
}