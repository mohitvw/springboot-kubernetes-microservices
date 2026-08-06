package com.ecommerce.product.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.service")
public record ApplicationProperties(String status) {
}
