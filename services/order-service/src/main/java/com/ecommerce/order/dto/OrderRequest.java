package com.ecommerce.order.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderRequest(

        @NotNull
        Long productId,

        @NotNull
        @Min(1)
        Integer quantity,

        @NotNull
        @DecimalMin(value = "0.01")
        BigDecimal amount
) {
}