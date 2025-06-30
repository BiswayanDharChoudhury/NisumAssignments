package com.nisum.NisumAssignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ecom-products")
public class EcomProductDashboardController {

    @Autowired
    private EcomProductRepository repository;

    @GetMapping
    public List<EcomProductEntity> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcomProductEntity> getProductById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EcomProductEntity> createProduct(@RequestBody EcomProductEntity product) {
        EcomProductEntity savedProduct = repository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcomProductEntity> updateProduct(
            @PathVariable Long id, 
            @RequestBody EcomProductEntity productDetails) {
        return repository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(productDetails.getName());
                    existingProduct.setDescription(productDetails.getDescription());
                    existingProduct.setPrice(productDetails.getPrice());
                    existingProduct.setStockQuantity(productDetails.getStockQuantity());
                    existingProduct.setCategory(productDetails.getCategory());
                    return ResponseEntity.ok(repository.save(existingProduct));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/category")
    public List<EcomProductEntity> getByCategory(@RequestParam String category) {
        return repository.findByCategory(category);
    }

    @GetMapping("/search/price-range")
    public List<EcomProductEntity> getByPriceRange(
            @RequestParam BigDecimal min, 
            @RequestParam BigDecimal max) {
        return repository.findByPriceBetween(min, max);
    }

    @GetMapping("/search/name")
    public List<EcomProductEntity> searchByName(@RequestParam String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/search/custom")
    public List<EcomProductEntity> customSearch(
            @RequestParam String keyword, 
            @RequestParam String category) {
        return repository.searchByNameAndCategory(keyword, category);
    }
}
