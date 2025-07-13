package com.example.monitoringdemo.controller;

import com.example.monitoringdemo.metrics.ApiHitCounter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final ApiHitCounter apiHitCounter;

    public DemoController(ApiHitCounter apiHitCounter) {
        this.apiHitCounter = apiHitCounter;
    }

    @GetMapping("/hello")
    public String hello() {
        apiHitCounter.increment();
        return "Hello, World!";
    }
}
