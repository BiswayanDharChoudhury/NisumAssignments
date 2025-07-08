package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterConfig {
    @Bean
    public Greeter greeterFromConfig() {
        return new Greeter("Hello from Java Config!");
    }
}
