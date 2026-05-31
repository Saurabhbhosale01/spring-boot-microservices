package com.order_service.order_service.entity;

import com.order_service.order_service.dto.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Builder
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    private String orderNumber;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;


    public static OrderEntity toEntity(Order order){
        return builder()
                .orderNumber(order.getOrderNumber())
                .skuCode(order.getSkuCode())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .build();
    }

    public static Order toDto(OrderEntity entity){
        return Order.builder()
                .uuid(entity.getUuid())
                .orderNumber(entity.getOrderNumber())
                .skuCode(entity.getSkuCode())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    public static OrderEntity updateEntity(Order order,OrderEntity entity){
        entity.setOrderNumber(order.getOrderNumber());
        entity.setSkuCode(order.getSkuCode());
        entity.setQuantity(order.getQuantity());
        entity.setQuantity(order.getQuantity());
        return entity;
    }

    @PrePersist
    public void prePersist(){
        this.uuid=UUID.randomUUID();
    }
}

