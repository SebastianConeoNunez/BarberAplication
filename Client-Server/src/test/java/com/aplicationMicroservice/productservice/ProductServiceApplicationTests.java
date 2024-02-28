package com.aplicationMicroservice.productservice;

import com.aplicationMicroservice.productservice.controller.ProductcController;
import com.aplicationMicroservice.productservice.dto.ProductRequest;
import com.aplicationMicroservice.productservice.dto.ProductResponse;
import com.aplicationMicroservice.productservice.model.Product;
import com.aplicationMicroservice.productservice.repository.ProducRepository;
import com.aplicationMicroservice.productservice.service.Productservice;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest

class ProductServiceApplicationTests {


	private final ProducRepository repository;

	private ProductcController controller;

	private Productservice service;

	@Autowired
	public ProductServiceApplicationTests(ProducRepository repository, Productservice service,ProductcController controller) {
		this.repository = repository;
		this.service =service ;
		this.controller = controller;

	}


	@Test
	public void Test2() {
		ProductRequest deseado = ProductRequest.builder()
				.name("Iphone 12")
				.descripction("Hola soy el 12")
				.price(BigDecimal.valueOf(122))
				.build();

		ProductRequest Escrito = ProductRequest.builder()
				.name("Iphone 12")
				.descripction("Hola soy el 12")
				.price(BigDecimal.valueOf(122))
				.build();

		//controller.createaProduct(Escrito);
		Assertions.assertEquals(deseado.getDescripction(),Escrito.getDescripction());
	}

	@Test
	public void Test3() {
		System.out.println(controller.GetAllProducts());
	}

	@DisplayName("Test unitario probar que guarde un usuario")
	@Test
	public void Test4() {
		ProductRequest deseado = ProductRequest.builder()
				.name("Iphone 22")
				.descripction("Hola soy el 22")
				.price(BigDecimal.valueOf(1000))
				.build();

		service.createProduct(deseado);
		Optional<Product> po  = repository.findByName(deseado.getName());
		Product savedProduct = po.orElse(null);

		ProductRequest vamoave = ProductRequest.builder()
				.name(savedProduct.getName())
				.descripction(savedProduct.getDescripction())
				.price(savedProduct.getPrice())
				.build();

		Assertions.assertEquals(deseado,vamoave);



	}
}




