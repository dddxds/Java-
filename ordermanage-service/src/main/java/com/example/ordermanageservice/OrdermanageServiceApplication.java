package com.example.ordermanageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrdermanageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermanageServiceApplication.class, args);
    }

}
