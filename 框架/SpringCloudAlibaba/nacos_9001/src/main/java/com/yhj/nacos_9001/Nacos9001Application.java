package com.yhj.nacos_9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Nacos9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Nacos9001Application.class, args);
    }

}
