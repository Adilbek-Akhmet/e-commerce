package com.example.deliveryservicemvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
//                "soft.ecommercelib",
                "com.example.deliveryservicemvc"
        }
)
public class DeliveryServiceMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceMvcApplication.class, args);
    }

}
