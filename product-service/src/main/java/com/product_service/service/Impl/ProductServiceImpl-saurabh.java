package com.product_service.service.Impl;

import com.product_service.dto.Product;
import com.product_service.entity.ProductEntity;
import com.product_service.repository.ProductRepository;
import com.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    @Override
    public void saveProduct(Product product) {
        ProductEntity entity = ProductEntity.toEntity(product);
        productRepository.save(entity);

    }

    @Override
    public Page<Product> getAllProduct(int page, int size , String sortDirection, boolean archive) {
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.fromString(sortDirection));
        return productRepository.getAllProduct(archive,pageable).map(productEntity -> {
            return ProductEntity.toDto(productEntity);
        });
    }

    @Override
    public Product getProductById(UUID productId) {
        ProductEntity product=productRepository.findByUuid(productId).orElseThrow(() -> new RuntimeException("product not found"));

        return ProductEntity.toDto(product);

    }

    @Override
    public void updateProduct(Product product ,UUID productId) {
        ProductEntity entity=productRepository.findByUuid(productId).orElseThrow(()->new RuntimeException("product not found"));

        ProductEntity.updateEntity(product,entity);

        productRepository.save(entity);

    }

    @Override
    public void archiveProduct(UUID productId,boolean status){
        ProductEntity product1 = productRepository.findByUuid(productId).orElseThrow(()->new RuntimeException("product not found"));
        product1.setActive(status);
        productRepository.save(product1);

    }


}
