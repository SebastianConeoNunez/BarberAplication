package com.aplicationMicroservice.inventoryservice.repository;

import com.aplicationMicroservice.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    List<Inventory> findByskcodeIn(List<String> Skcode);
}
