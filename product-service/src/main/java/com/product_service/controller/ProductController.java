package com.product_service.controller;

import com.product_service.dto.Product;
import com.product_service.response.Response;
import com.product_service.response.ResponseCode;
import com.product_service.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/master/product")
public class ProductController extends appController {

    private final ProductService productService;

    @Operation(summary = "create product")
    @PostMapping
    public ResponseEntity<Response> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return success(ResponseCode.PRODUCT_ADDED);
    }

    @Operation(summary = "get all  product")
    @GetMapping
    public ResponseEntity<Response> getAllProduct(@RequestParam(value = "page", defaultValue = "1") int  page,
                                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                                  @RequestParam(value = "sortDirection", defaultValue = "desc") String sortDirection,
                                                  @RequestParam(value = "archive", defaultValue = "false") boolean archive){
        return data(productService.getAllProduct(page,size,sortDirection,archive));
    }
    @Operation(summary = "get product by id")
    @GetMapping("/{productId}")
    public ResponseEntity<Response> getProductById(@PathVariable UUID productId){

        return data(productService.getProductById(productId));
    }

    @Operation(summary = "update product by id")
    @PutMapping("/{productId}")
    public ResponseEntity<Response> updateProduct(@RequestBody Product product, @PathVariable UUID productId){
        productService.updateProduct(product, productId);
        return success(ResponseCode.PRODUCT_UPDATED);
    }

    @Operation(summary = "delete(soft) product")
    @PutMapping("/{productId}/{status}")
    public ResponseEntity<Response> archiveProduct(@PathVariable UUID productId, @PathVariable boolean status){
        productService.archiveProduct(productId,status);
        return success(ResponseCode.PRODUCT_ARCHIVED);
    }



}
