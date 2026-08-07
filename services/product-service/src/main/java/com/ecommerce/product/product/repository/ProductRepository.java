package com.ecommerce.product.product.repository;

import com.ecommerce.product.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
