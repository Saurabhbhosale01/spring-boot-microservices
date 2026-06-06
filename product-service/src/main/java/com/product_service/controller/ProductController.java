package com.product_service.controller;

import com.product_service.dto.Product;
import com.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/master/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product){
         productService.saveProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable UUID productId){
       return productService.getProductById(productId);
    }


    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Product product, @PathVariable UUID productId){
        productService.updateProduct(product, productId);
    }



}
