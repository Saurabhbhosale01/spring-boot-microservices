package com.product_service.dto;

import com.product_service.ProductStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private UUID uuid;

    private String name;

    private String description;

    private String brand;

    private String category;

    private String sku;

    private Double price;

    private Double discount;

    private Double finalPrice;

    private Boolean active;

    private String imageUrl;

    private Double rating;

    private Integer totalReviews;

    private Double weight;

    private String color;

    private ProductStatus productStatus;
}
