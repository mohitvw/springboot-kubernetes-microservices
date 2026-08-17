package com.ecommerce.order.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PaymentClient {

    private final RestClient restClient;

    public PaymentClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://payment-service:8080")
                .build();
    }

    public boolean processPayment() {
        try {
            restClient.post()
                    .uri("/api/v1/payments")
                    .retrieve()
                    .toBodilessEntity();

            return true;

        } catch (Exception exception) {
            return false;
        }
    }
}