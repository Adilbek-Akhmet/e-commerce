package soft.product_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(
        scanBasePackages = {
                "soft.product_service",
                "soft.ecommercelib"
        }
)
@OpenAPIDefinition(info = @Info(title = "Product API", description = "Product Service", version = "${springdoc.swagger-ui.version}"))
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
