package com.project.nesordular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Integer careerOpportunities; // 1-5
    
    @Column(nullable = false)
    private Integer benefits; // 1-5
    
    @Column(nullable = false)
    private Integer cultureAndValues; // 1-5
    
    @Column(nullable = false)
    private Integer diversityAndInclusion; // 1-5
    
    @Column(nullable = false)
    private Integer seniorManagement; // 1-5
    
    @Column(nullable = false)
    private Integer workLifeBalance; // 1-5
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_review_id", nullable = false)
    private CompanyReview companyReview;
} 