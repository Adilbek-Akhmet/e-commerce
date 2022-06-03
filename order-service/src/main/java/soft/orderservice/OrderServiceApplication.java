package soft.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import soft.ecommercelib.feign.AccountFeign;
import soft.ecommercelib.feign.DeliveryFeign;
import soft.ecommercelib.feign.ProductFeign;

@EnableEurekaClient
@EnableFeignClients(basePackageClasses = {
        ProductFeign.class,
        DeliveryFeign.class,
        AccountFeign.class
})
@SpringBootApplication(
        scanBasePackages = {
                "soft.ecommercelib",
                "soft.orderservice"
        }
)
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
