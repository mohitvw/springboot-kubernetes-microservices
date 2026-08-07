package com.ecommerce.product.product.controller;

import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.dto.ProductRequest;
import com.ecommerce.product.product.dto.ProductResponse;
import com.ecommerce.product.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/ping")
    public PingResponse ping() {
        return productService.ping();
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable String id) {
        return productService.getProduct(Long.valueOf(id));
    }

    @PostMapping
    public ProductResponse create(@Valid @RequestBody ProductRequest request) {
        return productService.create(request);
    }

}

