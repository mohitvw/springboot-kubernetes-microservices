package com.ecommerce.product.product.controller;

import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products/ping")
    public PingResponse ping() {
        return productService.ping();
    }
}
