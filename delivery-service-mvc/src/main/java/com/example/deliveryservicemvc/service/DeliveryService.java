package com.example.deliveryservicemvc.service;

import com.example.deliveryservicemvc.document.DeliveryDoc;
import com.example.deliveryservicemvc.repository.DeliveryRepository;
import com.example.deliveryservicemvc.utility.DeliveryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import soft.ecommercelib.dto.account.EmployeeDto;
import soft.ecommercelib.dto.delivery.DeliveryDto;
import soft.ecommercelib.dto.order.OrderDto;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final RestTemplate restTemplate;
    private final DeliveryRepository deliveryRepository;

    @PostConstruct
    public void init() {
        deliveryRepository.deleteAll();
    }

    public void save(OrderDto orderDto) throws ExecutionException, InterruptedException {
        DeliveryDto deliveryDto = DeliveryDto.builder()
                .orderDto(orderDto)
                .deliveryEmployee(getEmployee())
                .build();
        save(deliveryDto).get();
    }

    public EmployeeDto getEmployee() throws ExecutionException, InterruptedException {
        return CompletableFuture.completedFuture(
                restTemplate.exchange("http://localhost:9000/employees/adam",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<EmployeeDto>() {
        }).getBody()).get();
    }
    @Async
    public CompletableFuture<DeliveryDoc> save(DeliveryDto deliveryDto) {
        return CompletableFuture.completedFuture(deliveryRepository.save(DeliveryMapper.toEntity(deliveryDto)));
    }

}
