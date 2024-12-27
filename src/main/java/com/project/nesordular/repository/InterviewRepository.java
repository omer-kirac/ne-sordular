package com.project.nesordular.repository;

import com.project.nesordular.model.Interview;
import com.project.nesordular.model.enums.OfferStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByCompanyId(Long companyId);
    List<Interview> findByUserId(Long userId);
    List<Interview> findByCompanyIdAndOfferStatus(Long companyId, OfferStatus offerStatus);
    List<Interview> findByCompanyIdOrderByInterviewDateDesc(Long companyId);
} 