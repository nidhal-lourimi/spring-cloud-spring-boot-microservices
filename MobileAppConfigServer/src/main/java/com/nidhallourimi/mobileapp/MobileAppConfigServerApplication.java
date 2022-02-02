package com.nidhallourimi.mobileapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigServer
public class MobileAppConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileAppConfigServerApplication.class, args);
    }




    }

