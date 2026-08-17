package com.ecommerce.order.controller;

import com.ecommerce.order.dto.OrderResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @GetMapping("/ping")
    public OrderResponse ping() {
        return new OrderResponse("order-service", "UP");
    }

    @PostMapping
    public OrderResponse createOrder() {
        return new OrderResponse(UUID.randomUUID().toString(), "CREATED");
    }
}
