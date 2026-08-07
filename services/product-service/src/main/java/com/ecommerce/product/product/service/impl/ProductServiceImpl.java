package com.ecommerce.product.product.service.impl;

import com.ecommerce.product.config.ApplicationProperties;
import com.ecommerce.product.config.SpringApplicationProperties;
import com.ecommerce.product.exception.ResourceNotFoundException;
import com.ecommerce.product.product.domain.Product;
import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.dto.ProductRequest;
import com.ecommerce.product.product.dto.ProductResponse;
import com.ecommerce.product.product.repository.ProductRepository;
import com.ecommerce.product.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ApplicationProperties applicationProperties;
    private final SpringApplicationProperties springApplicationProperties;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ApplicationProperties applicationProperties, SpringApplicationProperties springApplicationProperties,  ProductRepository productRepository) {
        this.applicationProperties = applicationProperties;
        this.springApplicationProperties = springApplicationProperties;
        this.productRepository = productRepository;
    }

    @Override
    public PingResponse ping() {
        return new PingResponse(springApplicationProperties.name(), applicationProperties.status());
    }

    /*@Override
    public List<ProductResponse> getAllProducts() {

        return List.of(

                new ProductResponse(
                        1L,
                        "MacBook Air M2",
                        "Apple Laptop",
                        BigDecimal.valueOf(999.99)
                ),

                new ProductResponse(
                        2L,
                        "Mechanical Keyboard",
                        "Apple Laptop",
                        BigDecimal.valueOf(89.99)
                ),

                new ProductResponse(
                        3L,
                        "Wireless Mouse",
                        "Apple Laptop",
                        BigDecimal.valueOf(29.99)
                )

        );

    }*/

    @Override
    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                ))
                .toList();
    }

    @Override
    public ProductResponse getProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                ))
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        Product savedProduct = productRepository.save(product);
        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice()
        );
    }


}
