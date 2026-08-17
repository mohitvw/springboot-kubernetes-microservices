package com.ecommerce.payment.controller;

import com.ecommerce.payment.dto.PaymentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @GetMapping("/ping")
    public PaymentResponse ping() {
        return new PaymentResponse("payment-service", "UP");
    }

    @PostMapping
    public PaymentResponse processPayment() {
        return new PaymentResponse(UUID.randomUUID().toString(), "SUCCESS");
    }
}
