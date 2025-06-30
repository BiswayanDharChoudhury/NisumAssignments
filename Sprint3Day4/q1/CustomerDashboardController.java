package com.nisum.NisumAssignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerDashboardController {

    @Autowired
    private CustomerDataRepository repository;

    // Create new customer
    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity savedCustomer = repository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) {
        Optional<CustomerEntity> customer = repository.findById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all customers
    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return repository.findAll();
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Additional query endpoints
    @GetMapping("/search/email")
    public List<CustomerEntity> searchByEmail(@RequestParam String keyword) {
        return repository.findByEmailContaining(keyword);
    }

    @GetMapping("/search/registered-after")
    public List<CustomerEntity> searchByRegistrationDate(
            @RequestParam LocalDate date) {
        return repository.findByRegisteredDateAfter(date);
    }

    @GetMapping("/search/name")
    public List<CustomerEntity> searchByName(@RequestParam String name) {
        return repository.findByNameExact(name);
    }
}
