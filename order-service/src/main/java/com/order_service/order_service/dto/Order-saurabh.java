package com.order_service.order_service.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Order {

    private Integer id;

    private UUID uuid;

    private String orderNumber;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;
}
