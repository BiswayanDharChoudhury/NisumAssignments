package com.nisum.NisumAssignments;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "registered_date", nullable = false)
    private LocalDate registeredDate;

    // Constructors
    public CustomerEntity() {}
    public CustomerEntity(String name, String email, LocalDate registeredDate) {
        this.name = name;
        this.email = email;
        this.registeredDate = registeredDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getRegisteredDate() { return registeredDate; }
    public void setRegisteredDate(LocalDate registeredDate) { 
        this.registeredDate = registeredDate; 
    }
}
