package com.aplicationMicroservice.orderservice;

import com.aplicationMicroservice.orderservice.Repository.OrderRepository;
import com.aplicationMicroservice.orderservice.dto.OrderLineItemsDto;
import com.aplicationMicroservice.orderservice.dto.OrderRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationClass {


    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:8.0.30");
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private OrderRepository producRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setUp() {
        mySQLContainer.start();
    }

    @AfterAll
    public static void tearDown() {
        mySQLContainer.stop();
    }

    @DynamicPropertySource
    static void Setpropieties(DynamicPropertyRegistry dynamicPropertyRegistry){
        dynamicPropertyRegistry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", mySQLContainer::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    public void TestCreateProduct() throws Exception {

        OrderRequest ordenansa  = request();
        String r = objectMapper.writeValueAsString(ordenansa);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(r))
                .andExpect(status().isCreated());
        Assertions.assertEquals(1,producRepository.findAll().size());
    }

    private OrderRequest request(){
        OrderRequest order = new OrderRequest();
        List<OrderLineItemsDto> lista = new ArrayList<>();
        OrderLineItemsDto objeto = new OrderLineItemsDto();
        objeto.setPrice(BigDecimal.valueOf(123300));
        objeto.setQuantity(2);
        objeto.setSkcode("Iphone15 pro");
        lista.add(objeto);
        order.setOrderLineItemsListDto(lista);

        return order;
    }


}
