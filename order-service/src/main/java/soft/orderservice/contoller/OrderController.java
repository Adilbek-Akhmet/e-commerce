package soft.orderservice.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import soft.ecommercelib.dto.account.CustomerDto;
import soft.ecommercelib.dto.order.OrderDto;
import soft.ecommercelib.dto.product.ProductDto;
import soft.ecommercelib.dto.product.ProductWithPort;
import soft.ecommercelib.feign.AccountFeign;
import soft.ecommercelib.feign.DeliveryFeign;
import soft.ecommercelib.feign.ProductFeign;
import soft.orderservice.rabbit.RabbitMQProducer;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final AccountFeign accountFeign;
    private final ProductFeign productFeign;
    private final DeliveryFeign deliveryFeign;
    private final RabbitMQProducer rabbitMQProducer;

    private final OrderDto orderDto = OrderDto.builder()
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

    @GetMapping("withoutFeign")
    public ProductWithPort getProductsWithoutFeign() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                        "http://localhost:8000/products",
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<ProductWithPort>() {
                        })
                .getBody();
    }

    @GetMapping("/feign")
    public ProductWithPort getProductsWithFeign() {
        return productFeign.findAll();
    }

    @GetMapping("/withoutRabbit")
    public void acceptOrderWithoutRabbit() throws InterruptedException {

        Thread.sleep(10);
        deliveryFeign.consumer(OrderDto.builder()
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
                .build());
//        rabbitMQProducer.publish(orderDto, "internal.exchange",
//                "internal.delivery.routing-key");
//        boolean contains = Optional.ofNullable(productFeign.exists(orderDto.getProductDto().getName()))
//                .map(ResponseEntity::getBody)
//                .orElseThrow(() -> new NoSuchElementException("Failed to get result from Product Feign with product: " + orderDto.getProductDto().getName()));
//
//        if (contains) {
//            deliveryFeign.consumer(orderDto);
//        } else {
//            throw new NoSuchElementException("Product not found");
//        }
    }

    @GetMapping("/rabbit")
    public void acceptOrderWithRabbit() throws InterruptedException {

        Thread.sleep(10);
        rabbitMQProducer.publish(OrderDto.builder()
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
                        .build(), "internal.exchange",
                "internal.delivery.routing-key");

//        boolean contains = Optional.ofNullable(productFeign.exists(orderDto.getProductDto().getName()))
//                .map(ResponseEntity::getBody)
//                .orElseThrow(() -> new NoSuchElementException("Failed to get result from Product Feign with product: " + orderDto.getProductDto().getName()));
//
//        if (contains) {
//            rabbitMQProducer.publish(orderDto, "internal.exchange",
//                    "internal.delivery.routing-key");
//        } else {
//            throw new NoSuchElementException("Product not found");
//        }
    }

}
