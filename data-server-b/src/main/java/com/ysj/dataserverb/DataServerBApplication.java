package com.ysj.dataserverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DataServerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataServerBApplication.class, args);
    }

}
