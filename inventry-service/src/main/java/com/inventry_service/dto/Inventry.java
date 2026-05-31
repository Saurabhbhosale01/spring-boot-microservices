package com.inventry_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Inventry {

    private Integer id;

    private UUID uuid;

    private String skuCode;

    private Integer quantity;

    private String warehouseName;

    private Boolean inStock;

}
