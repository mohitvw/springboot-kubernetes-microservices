package com.ecommerce.product.product.service.impl;

import com.ecommerce.product.config.ApplicationProperties;
import com.ecommerce.product.config.SpringApplicationProperties;
import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.dto.ProductResponse;
import com.ecommerce.product.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ApplicationProperties applicationProperties;
    private final SpringApplicationProperties springApplicationProperties;

    public ProductServiceImpl(ApplicationProperties applicationProperties, SpringApplicationProperties springApplicationProperties) {
        this.applicationProperties = applicationProperties;
        this.springApplicationProperties = springApplicationProperties;
    }

    @Override
    public PingResponse ping() {
        return new PingResponse(springApplicationProperties.name(), applicationProperties.status());
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        return List.of(

                new ProductResponse(
                        1L,
                        "MacBook Air M2",
                        BigDecimal.valueOf(999.99)
                ),

                new ProductResponse(
                        2L,
                        "Mechanical Keyboard",
                        BigDecimal.valueOf(89.99)
                ),

                new ProductResponse(
                        3L,
                        "Wireless Mouse",
                        BigDecimal.valueOf(29.99)
                )

        );

    }
}
