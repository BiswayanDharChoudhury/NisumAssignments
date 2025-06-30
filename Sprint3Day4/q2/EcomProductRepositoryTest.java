package com.nisum.NisumAssignments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EcomProductRepositoryTest {

    @Autowired
    private EcomProductRepository repository;

    @Test
    public void testFindByCategory() {
        repository.save(createProduct("Laptop", "Electronics", 999.99));
        repository.save(createProduct("Chair", "Furniture", 199.99));
        
        List<EcomProductEntity> electronics = repository.findByCategory("Electronics");
        assertThat(electronics).hasSize(1);
        assertThat(electronics.get(0).getName()).isEqualTo("Laptop");
    }

    @Test
    public void testPriceRangeSearch() {
        repository.save(createProduct("Product1", "Cat1", 50.00));
        repository.save(createProduct("Product2", "Cat1", 150.00));
        
        List<EcomProductEntity> results = repository.findByPriceBetween(
            new BigDecimal("100.00"), new BigDecimal("200.00")
        );
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("Product2");
    }

    @Test
    public void testNameSearch() {
        repository.save(createProduct("Wireless Mouse", "Electronics", 25.00));
        repository.save(createProduct("Gaming Mouse", "Electronics", 49.99));
        
        List<EcomProductEntity> results = repository.findByNameContainingIgnoreCase("mouse");
        assertThat(results).hasSize(2);
    }

    @Test
    public void testCustomSearch() {
        repository.save(createProduct("Apple iPhone", "Electronics", 999.00));
        repository.save(createProduct("Samsung Galaxy", "Electronics", 899.00));
        repository.save(createProduct("Apple Pie", "Food", 9.99));
        
        List<EcomProductEntity> results = repository.searchByNameAndCategory("apple", "Electronics");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("Apple iPhone");
    }

    private EcomProductEntity createProduct(String name, String category, double price) {
        EcomProductEntity product = new EcomProductEntity();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(BigDecimal.valueOf(price));
        return product;
    }
}
