package com.inventry_service.service;

import com.inventry_service.repository.InventryRepository;

public interface InventryService {

    boolean inStock(String skuCode, Integer quantity);
}
