package com.aplicationMicroservice.orderservice;

import com.aplicationMicroservice.orderservice.Controller.controller;
import com.aplicationMicroservice.orderservice.Repository.OrderRepository;
import com.aplicationMicroservice.orderservice.Service.OrderService;
import com.aplicationMicroservice.orderservice.dto.OrderLineItemsDto;
import com.aplicationMicroservice.orderservice.dto.OrderRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest

class OrderServiceApplicationTests {


	private final OrderRepository repository;

	private final OrderService service;


	private final controller con;


	@Autowired
	OrderServiceApplicationTests(OrderRepository repository, OrderService service, controller con) {
		this.repository = repository;
		this.service = service;
		this.con = con;
	}


	@Test
	void test1() {

		OrderRequest request = new OrderRequest();
		List<OrderLineItemsDto> lista = new ArrayList<>();
		lista.add(CrearObjeto());
		request.setOrderLineItemsListDto(lista);
		service.PlaceOrderr(request);
		Assertions.assertEquals(1,repository.findAll().size());
	}

	private OrderLineItemsDto CrearObjeto(){
		OrderLineItemsDto objeto = new OrderLineItemsDto();
		objeto.setSkcode("Llavero");
		objeto.setPrice(BigDecimal.valueOf(123456));
		objeto.setQuantity(1);
		return objeto;
	}


}
