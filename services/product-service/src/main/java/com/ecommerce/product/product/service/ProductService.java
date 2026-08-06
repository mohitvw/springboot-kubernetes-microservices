package com.ecommerce.product.product.service;

import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    PingResponse ping();

    List<ProductResponse> getAllProducts();
}
