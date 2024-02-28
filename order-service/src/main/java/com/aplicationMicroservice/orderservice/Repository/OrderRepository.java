package com.aplicationMicroservice.orderservice.Repository;

import com.aplicationMicroservice.orderservice.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
