package com.product_service.entity;

import com.product_service.dto.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Builder
@Data
@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public static ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .category(product.getCategory())
                .sku(product.getSku())
                .price(product.getPrice())
                .discount(product.getDiscount())
                .finalPrice(product.getFinalPrice())
                .active(product.getActive())
                .imageUrl(product.getImageUrl())
                .rating(product.getRating())
                .totalReviews(product.getTotalReviews())
                .weight(product.getWeight())
                .color(product.getColor())
                .build();
    }

    public static Product toDto(ProductEntity productEntity) {
        return Product.builder()
                .uuid(productEntity.getUuid())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .brand(productEntity.getBrand())
                .category(productEntity.getCategory())
                .sku(productEntity.getSku())
                .price(productEntity.getPrice())
                .discount(productEntity.getDiscount())
                .finalPrice(productEntity.getFinalPrice())
                .active(productEntity.getActive())
                .imageUrl(productEntity.getImageUrl())
                .rating(productEntity.getRating())
                .totalReviews(productEntity.getTotalReviews())
                .weight(productEntity.getWeight())
                .color(productEntity.getColor())
                .build();
    }

    public static ProductEntity updateEntity(Product product, ProductEntity entity) {

        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setBrand(product.getBrand());
        entity.setCategory(product.getCategory());
        entity.setSku(product.getSku());
        entity.setPrice(product.getPrice());
        entity.setDiscount(product.getDiscount());
        entity.setFinalPrice(product.getFinalPrice());
        entity.setActive(product.getActive());
        entity.setImageUrl(product.getImageUrl());
        entity.setRating(product.getRating());
        entity.setTotalReviews(product.getTotalReviews());
        entity.setWeight(product.getWeight());
        entity.setColor(product.getColor());
        return entity;
    }

    @PrePersist
    public void prepersist  (){
        this.uuid=UUID.randomUUID();
    }
}
