package com.nidhallourimi.app.ws.Configuration;

import com.nidhallourimi.app.ws.exceptions.FeignErrorDecoder;
import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    Logger.Level feignLoggerLover() {
        return Logger.Level.FULL;
    }

    @Bean
    public FeignErrorDecoder feignErrorDecoder(){return new FeignErrorDecoder();}

}
