package com.aplicationMicroservice.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class OrderLineItemsDto {
    private String Skcode;
    private BigDecimal price;
}
