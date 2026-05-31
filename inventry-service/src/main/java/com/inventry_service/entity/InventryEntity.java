package com.inventry_service.entity;

import com.inventry_service.dto.Inventry;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Builder
@Data
@Table(name = "inventry")
public class InventryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @Column(nullable = false, unique = true)
    private String skuCode;

    @Column(nullable = false)
    private Integer quantity;

    private String warehouseName;

    private Boolean inStock;

    public static Inventry toDto(InventryEntity entity){
        return Inventry.builder()
                .uuid(entity.getUuid())
                .skuCode(entity.getSkuCode())
                .quantity(entity.getQuantity())
                .warehouseName(entity.getWarehouseName())
                .inStock(entity.getInStock())
                .build();
    }

    public static InventryEntity toEntity(Inventry inventry){
        return InventryEntity.builder()
                .skuCode(inventry.getSkuCode())
                .quantity(inventry.getQuantity())
                .warehouseName(inventry.getWarehouseName())
                .inStock(inventry.getInStock())
                .build();
    }

    public static InventryEntity updateEntity(Inventry inventry, InventryEntity entity){
        entity.setSkuCode(inventry.getSkuCode());
        entity.setWarehouseName(inventry.getWarehouseName());
        entity.setQuantity(inventry.getQuantity());
        entity.setInStock(inventry.getInStock());
        return entity;
    }


    public void prePersist(){
        this.uuid=UUID.randomUUID();
    }

}
