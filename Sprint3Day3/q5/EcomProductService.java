package com.nisum.NisumAssignments;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EcomProductService {
    private final Map<Long, EcomProduct> products = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public EcomProductService() {
        createProduct(new EcomProduct(null, "Laptop", "High-performance laptop", new BigDecimal("999.99"), 50, "Electronics"));
        createProduct(new EcomProduct(null, "Smartphone", "Latest model", new BigDecimal("699.99"), 100, "Electronics"));
        createProduct(new EcomProduct(null, "Desk Chair", "Ergonomic office chair", new BigDecimal("199.99"), 30, "Furniture"));
    }

    public EcomProduct createProduct(EcomProduct product) {
        product.setId(nextId.getAndIncrement());
        products.put(product.getId(), product);
        return product;
    }

    public EcomProduct updateProduct(Long id, EcomProduct product) {
        if (!products.containsKey(id)) throw new EcomResourceNotFoundException("Product not found");
        product.setId(id);
        products.put(id, product);
        return product;
    }

    public EcomProduct getProductById(Long id) {
        EcomProduct product = products.get(id);
        if (product == null) throw new EcomResourceNotFoundException("Product not found");
        return product;
    }

    public void deleteProduct(Long id) {
        if (!products.containsKey(id)) throw new EcomResourceNotFoundException("Product not found");
        products.remove(id);
    }

    public List<EcomProduct> searchProducts(
            int page, int size, String category, 
            BigDecimal minPrice, BigDecimal maxPrice, 
            String sortField, String sortDirection) {
        
        Comparator<EcomProduct> comparator = getComparator(sortField, sortDirection);
        
        return products.values().stream()
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .filter(p -> minPrice == null || p.getPrice().compareTo(minPrice) >= 0)
            .filter(p -> maxPrice == null || p.getPrice().compareTo(maxPrice) <= 0)
            .sorted(comparator)
            .skip((long) page * size)
            .limit(size)
            .collect(Collectors.toList());
    }

    private Comparator<EcomProduct> getComparator(String sortField, String sortDirection) {
        if (sortField == null) return (a, b) -> 0;
        
        Comparator<EcomProduct> comparator;
        switch (sortField.toLowerCase()) {
            case "price": comparator = Comparator.comparing(EcomProduct::getPrice); break;
            case "name": comparator = Comparator.comparing(EcomProduct::getName); break;
            case "stock": comparator = Comparator.comparing(EcomProduct::getStockQuantity); break;
            default: comparator = Comparator.comparing(EcomProduct::getId);
        }
        
        return "desc".equalsIgnoreCase(sortDirection) ? 
               comparator.reversed() : comparator;
    }
}
