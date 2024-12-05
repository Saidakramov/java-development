package com.example.demo.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    @Bean
    public String getGreeting() {
        return  "Hello friend!";
    }
}
