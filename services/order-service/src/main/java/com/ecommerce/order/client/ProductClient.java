package com.ecommerce.order.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://product-service:8080")
                .build();
    }

    public boolean productExists(Long productId) {
        try {
            restClient.get()
                    .uri("/api/v1/products/{id}", productId)
                    .retrieve()
                    .toBodilessEntity();

            return true;

        } catch (Exception exception) {
            return false;
        }
    }
}