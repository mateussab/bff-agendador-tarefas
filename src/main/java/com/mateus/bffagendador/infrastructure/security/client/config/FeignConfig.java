package com.mateus.bffagendador.infrastructure.security.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignError feignErro(){
        return new FeignError();
    }
}
