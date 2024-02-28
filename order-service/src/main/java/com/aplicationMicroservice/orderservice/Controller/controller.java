package com.aplicationMicroservice.orderservice.Controller;

import com.aplicationMicroservice.orderservice.Model.Order;
import com.aplicationMicroservice.orderservice.Service.OrderService;
import com.aplicationMicroservice.orderservice.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class controller {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String PlaceOrder(@RequestBody OrderRequest orderRequest){
        orderService.PlaceOrderr(orderRequest);
        return "Order created successfully";
    }


}
