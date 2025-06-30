package com.nisum.NisumAssignments;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/ecom-products")
public class EcomProductController {

    @Autowired
    private EcomProductService productService;

    @PostMapping
    public ResponseEntity<EcomProduct> createProduct(@Valid @RequestBody EcomProduct product) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcomProduct> updateProduct(
            @PathVariable Long id, 
            @Valid @RequestBody EcomProduct product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcomProduct> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<EcomProduct>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String sort) {
        
        String sortField = "id";
        String sortDirection = "asc";
        if (sort != null && !sort.isEmpty()) {
            String[] sortParams = sort.split(",");
            sortField = sortParams[0];
            if (sortParams.length > 1) sortDirection = sortParams[1];
        }

        List<EcomProduct> products = productService.searchProducts(
            page, size, category, minPrice, maxPrice, sortField, sortDirection
        );
        
        Page<EcomProduct> pageResponse = new PageImpl<>(
            products,
            PageRequest.of(page, size),
            productService.searchProducts(0, Integer.MAX_VALUE, 
                category, minPrice, maxPrice, null, null).size()
        );
        
        return ResponseEntity.ok(pageResponse);
    }
}
