package com.nidhallourimi.mobileapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MobileAppConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileAppConfigServerApplication.class, args);
    }

}
