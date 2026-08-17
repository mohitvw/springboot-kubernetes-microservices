package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderRequest;
import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest request) {

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