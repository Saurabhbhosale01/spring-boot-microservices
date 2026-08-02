package com.product_service.service;

import com.product_service.dto.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;


public interface ProductService {

    void saveProduct(Product product);

    Page<Product> getAllProduct(int page, int size , String sortDirection, boolean archive);

    Product getProductById(UUID productId);

    void updateProduct(Product product ,UUID productId);

    void archiveProduct(UUID productId, boolean status);
}
