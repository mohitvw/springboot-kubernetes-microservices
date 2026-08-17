package com.ecommerce.order.service;

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

    public OrderService(
            OrderRepository orderRepository,
            ProductClient productClient) {

        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public OrderResponse createOrder(OrderRequest request) {

        if (!productClient.productExists(request.productId())) {
            throw new IllegalArgumentException(
                    "Product not found: " + request.productId()
            );
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