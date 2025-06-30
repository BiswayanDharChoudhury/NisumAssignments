package com.nisum.NisumAssignments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface CustomerDataRepository extends JpaRepository<CustomerEntity, Long> {

    // Find customers with email containing keyword
    List<CustomerEntity> findByEmailContaining(String keyword);

    // Find customers registered after specific date
    List<CustomerEntity> findByRegisteredDateAfter(LocalDate date);

    // Custom query to find customers by exact name match
    @Query("SELECT c FROM CustomerEntity c WHERE c.name = :name")
    List<CustomerEntity> findByNameExact(@Param("name") String name);
}
