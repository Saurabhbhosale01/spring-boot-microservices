package com.product_service.service.Impl;

import com.product_service.dto.Product;
import com.product_service.entity.ProductEntity;
import com.product_service.repository.ProductRepository;
import com.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

//    @Autowired
//    private ProductService productService;

    @Override
    public void saveProduct(Product product) {
        ProductEntity entity = ProductEntity.toEntity(product);
        productRepository.save(entity);

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().stream()
                .map(ProductEntity::toDto).toList();
    }


}
