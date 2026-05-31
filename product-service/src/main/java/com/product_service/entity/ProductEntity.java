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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    private String name;

    private double discount;

    private double price;

    private double rating;

    public static ProductEntity toEntity(Product product){
      return ProductEntity.builder()
              .name(product.getName())
              .discount(product.getDiscount())
              .price(product.getPrice())
              .rating(product.getRating())
              .build();

    }

    public static Product toDto(ProductEntity productEntity){
        return Product.builder()
                .uuid(productEntity.getUuid())
                .name(productEntity.getName())
                .discount(productEntity.getDiscount())
                .price(productEntity.getPrice())
                .rating((productEntity.getRating()))
                .build();
    }

    public static ProductEntity updateEntity(Product product,ProductEntity entity){
        entity.setName(product.getName());
        entity.setDiscount(product.getDiscount());
        entity.setPrice(product.getPrice());
        entity.setRating(product.getRating());
        return entity;
        }

    @PrePersist
    public void prepersist  (){
        this.uuid=UUID.randomUUID();
    }
}
