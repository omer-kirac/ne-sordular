package com.project.nesordular.repository;

import com.project.nesordular.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByName(String name);
    
    @Query("SELECT c FROM Company c ORDER BY c.averageRating DESC")
    List<Company> findAllOrderByRatingDesc();
    
    List<Company> findByNameContainingIgnoreCase(String name);
} 