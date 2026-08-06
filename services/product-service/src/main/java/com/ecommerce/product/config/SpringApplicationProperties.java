package com.ecommerce.product.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.application")
public record SpringApplicationProperties(String name) {
}
