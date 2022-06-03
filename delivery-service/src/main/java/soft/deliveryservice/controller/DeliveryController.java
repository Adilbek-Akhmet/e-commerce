package soft.deliveryservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import soft.deliveryservice.document.DeliveryDoc;
import soft.deliveryservice.service.DeliveryService;
import soft.ecommercelib.dto.account.CustomerDto;
import soft.ecommercelib.dto.order.OrderDto;
import soft.ecommercelib.dto.product.ProductDto;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public void consumerWithoutRabbit(@RequestBody OrderDto orderDto) throws InterruptedException {
        log.info("Consumed through Feign order: {}", orderDto);
//        deliveryService.save(orderDto);
        Thread.sleep(50);
//        log.info("Order with id: {} was saved", orderDto.getProductDto().getId());
    }

    @GetMapping
    public Mono<DeliveryDoc> deliver() {
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
        return deliveryService.save(orderDto);
    }


}
