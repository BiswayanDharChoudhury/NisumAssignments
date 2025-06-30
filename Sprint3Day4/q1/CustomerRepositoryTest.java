package com.nisum.NisumAssignments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerDataRepository repository;

    @Test
    public void testEmailSearch() {
        repository.save(new CustomerEntity("Alice", "alice@example.com", LocalDate.now()));
        repository.save(new CustomerEntity("Bob", "bob@test.com", LocalDate.now()));
        
        List<CustomerEntity> results = repository.findByEmailContaining("example");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("Alice");
    }

    @Test
    public void testDateFilter() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        repository.save(new CustomerEntity("Old", "old@test.com", yesterday));
        repository.save(new CustomerEntity("New", "new@test.com", LocalDate.now()));
        
        List<CustomerEntity> results = repository.findByRegisteredDateAfter(yesterday);
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("New");
    }

    @Test
    public void testNameQuery() {
        repository.save(new CustomerEntity("Charlie", "charlie@test.com", LocalDate.now()));
        repository.save(new CustomerEntity("David", "david@test.com", LocalDate.now()));
        
        List<CustomerEntity> results = repository.findByNameExact("Charlie");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getEmail()).isEqualTo("charlie@test.com");
    }
}
