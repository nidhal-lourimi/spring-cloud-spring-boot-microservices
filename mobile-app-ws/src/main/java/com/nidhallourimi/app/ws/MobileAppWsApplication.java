package com.nidhallourimi.app.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient

public class MobileAppWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileAppWsApplication.class, args);
    }

}

/*
@Configuration
public class ReloadLookupEvent implements ApplicationListener<RefreshScopeRefreshedEvent> {
    @Autowired
    private CacheService cacheService;

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {
        cacheService.refreshLookUp();
    }
}*/
