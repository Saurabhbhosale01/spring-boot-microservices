package com.inventry_service.repository;

import com.inventry_service.entity.InventryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventryRepository extends JpaRepository<InventryEntity,Integer> {

    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity);}
