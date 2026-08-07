package com.ecommerce.product.product.service;

import com.ecommerce.product.product.dto.PingResponse;
import com.ecommerce.product.product.dto.ProductRequest;
import com.ecommerce.product.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    PingResponse ping();

    List<ProductResponse> getProducts();

    ProductResponse getProduct(Long id);

    ProductResponse create(ProductRequest request) ;
}
