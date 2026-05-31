package com.product_service.service;

import com.product_service.dto.Product;

import java.util.List;


public interface ProductService {

    void saveProduct(Product product);

    List<Product> getAllProduct();
}
