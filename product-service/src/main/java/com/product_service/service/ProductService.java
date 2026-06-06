package com.product_service.service;

import com.product_service.dto.Product;

import java.util.List;
import java.util.UUID;


public interface ProductService {

    void saveProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(UUID productId);

    void updateProduct(Product product ,UUID productId);
}
