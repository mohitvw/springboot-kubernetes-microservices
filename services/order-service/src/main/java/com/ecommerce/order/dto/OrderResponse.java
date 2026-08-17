package com.ecommerce.order.dto;

import com.ecommerce.order.model.Order;

import java.math.BigDecimal;

public record OrderResponse(
        Long orderId,
        Long productId,
        Integer quantity,
        BigDecimal amount,
        String status
) {

    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProductId(),
                order.getQuantity(),
                order.getAmount(),
                order.getStatus()
        );
    }
}