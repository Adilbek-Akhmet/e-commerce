package soft.deliveryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import soft.deliveryservice.document.DeliveryDoc;
import soft.deliveryservice.repository.DeliveryRepository;
import soft.deliveryservice.utility.DeliveryMapper;
import soft.ecommercelib.dto.account.EmployeeDto;
import soft.ecommercelib.dto.delivery.DeliveryDto;
import soft.ecommercelib.dto.order.OrderDto;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final WebClient webClient;
    private final DeliveryRepository deliveryRepository;

    @PostConstruct
    public void init() {
        deliveryRepository.deleteAll().subscribe();
    }

    public Mono<DeliveryDoc> save(OrderDto orderDto) {
        return webClient.get().uri("/employees/adam")
                .retrieve()
                .bodyToMono(EmployeeDto.class)
                .map(employeeDto -> DeliveryDto.builder()
                            .orderDto(orderDto)
                            .deliveryEmployee(employeeDto)
                            .build())
                .map(DeliveryMapper::toEntity)
                .flatMap(this.deliveryRepository::save);
    }
}
