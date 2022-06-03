package com.example.deliveryservicemvc.controller;

import com.example.deliveryservicemvc.document.DeliveryDoc;
import com.example.deliveryservicemvc.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import soft.ecommercelib.dto.account.CustomerDto;
import soft.ecommercelib.dto.order.OrderDto;
import soft.ecommercelib.dto.product.ProductDto;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;



    @GetMapping
    public void deliver() throws ExecutionException, InterruptedException {
        //OrderDto Test
        OrderDto orderDto = OrderDto.builder()
                .customerDto(CustomerDto.builder()
                        .username("username")
                        .email("email")
                        .address("address")
                        .build())
                .productDto(ProductDto.builder()
                        .name("phone")
                        .description("A mobile phone is a wireless handheld device that allows users to make and receive calls. While the earliest generation of mobile phones could only make and receive calls, today's mobile phones do a lot more, accommodating web browsers, games, cameras, video players and navigational systems.")
                        .price(BigDecimal.valueOf(2000))
                        .quantity(555)
                        .build())
                .mobileNumber("mobileNumber")
                .address("address")
                .build();
        deliveryService.save(orderDto);
//        return orderDto;
    }

    @PostMapping
    public void consumerWithoutRabbit(@RequestBody OrderDto orderDto) throws InterruptedException {
        log.info("Consumed through Feign order: {}", orderDto);
//        deliveryService.save(orderDto);
        Thread.sleep(50);
//        log.info("Order with id: {} was saved", orderDto.getProductDto().getId());
    }
}
