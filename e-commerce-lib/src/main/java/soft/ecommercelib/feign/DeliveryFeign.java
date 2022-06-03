package soft.ecommercelib.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import soft.ecommercelib.dto.order.OrderDto;

@FeignClient(name = "delivery-service")
public interface DeliveryFeign {

    @PostMapping("/delivery")
    void consumer(@RequestBody OrderDto orderDto);
}
