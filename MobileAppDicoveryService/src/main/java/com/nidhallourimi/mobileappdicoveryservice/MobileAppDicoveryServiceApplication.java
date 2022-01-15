package com.nidhallourimi.mobileappdicoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MobileAppDicoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileAppDicoveryServiceApplication.class, args);
    }

}
