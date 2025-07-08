package com.example.demo.autoconfig;

import com.example.demo.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@Configuration
@ConditionalOnMissingBean(Greeter.class)
public class GreeterAutoConfiguration {
    @Bean
    public Greeter greeterAutoConfig() {
        return new Greeter("Hello from AutoConfiguration!");
    }
}
