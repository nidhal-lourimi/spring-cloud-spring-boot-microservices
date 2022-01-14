package com.nidhallourimi.accountmanagementmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountManagementMicroserviceApplication {


    public static void main(String[] args) {
        SpringApplication.run(AccountManagementMicroserviceApplication.class, args);
    }

}
