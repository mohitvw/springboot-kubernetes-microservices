package com.ecommerce.product.product.controller;

import com.ecommerce.product.product.dto.PingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {

    @GetMapping("/api/v1/products/ping")
    public PingResponse ping() {
        return new PingResponse("product-service", "UP");
    }
}
