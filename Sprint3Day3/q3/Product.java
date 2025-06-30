package com.nisum.NisumAssignments;

import jakarta.validation.constraints.*;

public class Product {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3-50 characters")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    @DecimalMax(value = "10000.00", message = "Price cannot exceed 10000.00")
    private Double price;

    @Pattern(regexp = "^[A-Z]{3}-\\d{4}$", message = "SKU must be in AAA-1234 format")
    private String sku; 
  
    public Product() {}
    
    public Product(Long id, String name, Double price, String sku) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    // Getters and setters for all fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
}
