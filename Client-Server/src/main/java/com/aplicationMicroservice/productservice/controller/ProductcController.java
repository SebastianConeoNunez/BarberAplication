package com.aplicationMicroservice.productservice.controller;

import com.aplicationMicroservice.productservice.dto.ProductRequest;
import com.aplicationMicroservice.productservice.dto.ProductResponse;
import com.aplicationMicroservice.productservice.service.Productservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")

public class ProductcController {

    private final Productservice productservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createaProduct(@RequestBody ProductRequest productRequest){
        productservice.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> GetAllProducts (){
        return productservice.GetAllprod();
    }
}
