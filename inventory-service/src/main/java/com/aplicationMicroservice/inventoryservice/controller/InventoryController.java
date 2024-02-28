package com.aplicationMicroservice.inventoryservice.controller;

import com.aplicationMicroservice.inventoryservice.dto.InventoryResponse;
import com.aplicationMicroservice.inventoryservice.service.InventoryService;
import jakarta.servlet.annotation.HttpMethodConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> IsInStock(@RequestParam("skucode") List<String> Skcode){

        return service.Stock(Skcode);
    }
}
