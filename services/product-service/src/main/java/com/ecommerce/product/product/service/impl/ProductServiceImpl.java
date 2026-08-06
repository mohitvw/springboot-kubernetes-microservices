package com.ecommerce.product.product.service.impl;

import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.dto.ProductResponse;
import com.ecommerce.product.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public PingResponse ping() {
        return new PingResponse("product-service", "UP")    ;
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
