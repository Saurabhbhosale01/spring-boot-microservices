package com.inventry_service.controller;

import com.inventry_service.service.InventryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/master/inventry")
@RequiredArgsConstructor
public class InventryController {

    private final InventryService inventryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean inStock(@RequestParam String skuCode,@RequestParam  Integer quantity){
        return inventryService.inStock(skuCode,quantity);
    }
}
