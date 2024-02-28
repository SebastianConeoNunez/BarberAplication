package com.aplicationMicroservice.productservice.service;

import com.aplicationMicroservice.productservice.dto.ProductRequest;
import com.aplicationMicroservice.productservice.dto.ProductResponse;
import com.aplicationMicroservice.productservice.model.Product;
import com.aplicationMicroservice.productservice.repository.ProducRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class Productservice {

   private final ProducRepository repository;

    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .descripction(productRequest.getDescripction())
                .price(productRequest.getPrice())
                .build();

        repository.save(product);
        log.info("Product {} was creates",product.getId());
    }

    public List<ProductResponse> GetAllprod() {
        List<Product> allProd = repository.findAll();
       return allProd.stream().map(this::mapToPRODUCTRESPONSE).toList();

    }

    private ProductResponse mapToPRODUCTRESPONSE(Product product){
        return   ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .descripction(product.getDescripction())
                .price(product.getPrice())
                .build();
    }
}
