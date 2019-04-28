package com.ysj.dataservera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DataServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataServerAApplication.class, args);
    }

}
