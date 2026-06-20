package com.product_service.controller;

import com.product_service.dto.Product;
import com.product_service.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "create product")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product){
         productService.saveProduct(product);
    }

    @Operation(summary = "get all  product")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @Operation(summary = "get product by id")
    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable UUID productId){
       return productService.getProductById(productId);
    }

    @Operation(summary = "update product by id")
    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Product product, @PathVariable UUID productId){
        productService.updateProduct(product, productId);
    }

    @Operation(summary = "delete(soft) product")
    @PutMapping("/{productId}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public void archiveProduct(@PathVariable UUID productId, @PathVariable boolean status){
        productService.archiveProduct(productId,status);
    }



}
