package com.project.nesordular.model;

import com.project.nesordular.model.enums.PaymentPeriod;
import com.project.nesordular.model.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salaries")
public class Salary {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Double baseSalary;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentPeriod paymentPeriod;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;
    
    @Column
    private Double bonus;
    
    @Column
    private Double stocks;
    
    @Column
    private Double profitSharing;
    
    @Column
    private Double commission;
    
    @Column
    private Double tips;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
} 