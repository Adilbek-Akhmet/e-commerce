package soft.ecommercelib.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import soft.ecommercelib.dto.product.ProductWithPort;

@FeignClient(name = "product-service")
public interface ProductFeign {

    @GetMapping("/products")
    ProductWithPort findAll();

    @GetMapping("/products/{productName}")
    ResponseEntity<Boolean> exists(@PathVariable String productName);
}
