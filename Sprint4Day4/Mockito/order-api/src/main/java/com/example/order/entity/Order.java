package com.example.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

    public Order() {}

    public Order(String description) {
        this.description = description;
    }

    public Long getId() { return id; }
    public String getDescription() { return description; }
    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
}
