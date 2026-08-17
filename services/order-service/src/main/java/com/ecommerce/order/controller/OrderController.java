package com.ecommerce.order.controller;

import com.ecommerce.order.dto.OrderRequest;
import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/ping")
    public OrderResponse ping() {
        return new OrderResponse(
                null,
                null,
                null,
                null,
                "UP"
        );
    }

    @PostMapping
    public OrderResponse createOrder(
            @Valid @RequestBody OrderRequest request) {

        return orderService.createOrder(request);
    }
}