package com.order_service.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;

    private UUID uuid;

    private String orderNumber;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;


}
