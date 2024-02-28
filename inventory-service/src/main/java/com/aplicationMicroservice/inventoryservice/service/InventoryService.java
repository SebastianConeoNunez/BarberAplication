package com.aplicationMicroservice.inventoryservice.service;

import com.aplicationMicroservice.inventoryservice.dto.InventoryResponse;
import com.aplicationMicroservice.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class InventoryService {

    @Autowired
    private final InventoryRepository repository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> Stock(List<String> skcode) {
        return repository.findByskcodeIn(skcode).stream().map(inventory ->
                InventoryResponse.builder()
                        .skcode(inventory.getSkcode())
                        .IsInStock(inventory.getQuantity() > 0)
                        .quantity(inventory.getQuantity())
                        .build()).toList();
    }
}
