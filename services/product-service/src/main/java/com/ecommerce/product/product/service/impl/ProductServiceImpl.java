package com.ecommerce.product.product.service.impl;

import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public PingResponse ping() {
        return new PingResponse("product-service", "UP")    ;
    }
}
