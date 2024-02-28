package com.aplicationMicroservice.orderservice.dto;

import com.aplicationMicroservice.orderservice.Model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest {
    private List<OrderLineItemsDto> OrderLineItemsListDto;
}
