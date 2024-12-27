package com.project.nesordular.repository;

import com.project.nesordular.model.CompanyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompanyReviewRepository extends JpaRepository<CompanyReview, Long> {
    List<CompanyReview> findByCompanyId(Long companyId);
    List<CompanyReview> findByUserId(Long userId);
    List<CompanyReview> findByCompanyIdOrderByCreatedAtDesc(Long companyId);
} 