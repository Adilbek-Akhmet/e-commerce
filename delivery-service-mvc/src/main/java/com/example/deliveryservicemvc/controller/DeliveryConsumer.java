package com.example.deliveryservicemvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import soft.ecommercelib.dto.order.OrderDto;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryConsumer {

    @RabbitListener(queues = "${rabbitmq.queues.delivery}")
    public void consumer(OrderDto orderDto) throws InterruptedException {
        log.info("Consumed order: {} from queue", orderDto);
//        deliveryService.save(orderDto);
        Thread.sleep(50);
//        log.info("Order with id: {} was saved", orderDto.getProductDto().getId());
    }
}
