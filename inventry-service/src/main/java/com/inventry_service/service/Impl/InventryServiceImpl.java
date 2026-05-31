package com.inventry_service.service.Impl;

import com.inventry_service.repository.InventryRepository;
import com.inventry_service.service.InventryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventryServiceImpl implements InventryService {

    @Autowired
    private InventryRepository inventryRepository;

    public boolean inStock(String skuCode, Integer quantity){
        return inventryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode,quantity);

    }
}
