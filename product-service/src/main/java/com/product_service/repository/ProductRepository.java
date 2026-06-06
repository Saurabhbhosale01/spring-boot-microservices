package com.product_service.repository;

import com.product_service.dto.Product;
import com.product_service.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

//    @Query(value = "select * from product where uuid = :productId", nativeQuery = true)
//    Product getProductById(@Param("productId") UUID productId);

    Optional<ProductEntity> findByUuid(UUID uuid);
}
