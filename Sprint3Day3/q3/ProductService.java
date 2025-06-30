package com.nisum.NisumAssignments;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    // CRUD methods same as before
    public List<Product> getAllProducts() { /* ... */ }
    public Product getProductById(Long id) { /* ... */ }
    public Product createProduct(Product product) { /* ... */ }
    public Product updateProduct(Long id, Product product) { /* ... */ }
    public void deleteProduct(Long id) { /* ... */ }
}
