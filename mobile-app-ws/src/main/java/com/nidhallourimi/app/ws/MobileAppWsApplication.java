package com.nidhallourimi.app.ws;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MobileAppWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileAppWsApplication.class, args);
    }

}

