package com.project.nesordular.repository;

import com.project.nesordular.model.Salary;
import com.project.nesordular.model.enums.PaymentPeriod;
import com.project.nesordular.model.enums.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findByCompanyId(Long companyId);
    List<Salary> findByUserId(Long userId);
    
    @Query("SELECT AVG(s.baseSalary) FROM Salary s WHERE s.company.id = :companyId AND s.paymentPeriod = :period AND s.currency = :currency")
    Double findAverageBaseSalaryByCompanyAndPeriodAndCurrency(
        @Param("companyId") Long companyId,
        @Param("period") PaymentPeriod period,
        @Param("currency") Currency currency
    );
    
    List<Salary> findByCompanyIdAndPaymentPeriodAndCurrency(Long companyId, PaymentPeriod period, Currency currency);
} 