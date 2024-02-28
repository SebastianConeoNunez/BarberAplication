package com.aplicationMicroservice.productservice.repository;

import com.aplicationMicroservice.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProducRepository extends MongoRepository<Product,String> {

    Optional<Product> findByName(String name);
}
