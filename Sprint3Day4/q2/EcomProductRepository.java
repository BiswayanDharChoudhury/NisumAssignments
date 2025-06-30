package com.nisum.NisumAssignments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface EcomProductRepository extends JpaRepository<EcomProductEntity, Long> {

    List<EcomProductEntity> findByCategory(String category);
    List<EcomProductEntity> findByPriceBetween(BigDecimal min, BigDecimal max);
    List<EcomProductEntity> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM EcomProductEntity p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) AND p.category = :category")
    List<EcomProductEntity> searchByNameAndCategory(@Param("keyword") String keyword, @Param("category") String category);
}
