package com.example.monitoringdemo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class ApiHitCounter {

    private final Counter apiHitCounter;

    public ApiHitCounter(MeterRegistry meterRegistry) {
        this.apiHitCounter = meterRegistry.counter("api_hits_total");
    }

    public void increment() {
        apiHitCounter.increment();
    }
}
