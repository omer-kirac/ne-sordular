package com.project.nesordular.service;

import com.project.nesordular.model.Salary;
import com.project.nesordular.model.enums.PaymentPeriod;
import com.project.nesordular.model.enums.Currency;
import com.project.nesordular.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public Salary createSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(Long id) {
        return salaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary not found with id: " + id));
    }

    public List<Salary> getSalariesByCompanyId(Long companyId) {
        return salaryRepository.findByCompanyId(companyId);
    }

    public List<Salary> getSalariesByUserId(Long userId) {
        return salaryRepository.findByUserId(userId);
    }

    public Double getAverageBaseSalary(Long companyId, PaymentPeriod period, Currency currency) {
        return salaryRepository.findAverageBaseSalaryByCompanyAndPeriodAndCurrency(companyId, period, currency);
    }

    public List<Salary> getSalariesByCompanyAndPeriodAndCurrency(Long companyId, PaymentPeriod period, Currency currency) {
        return salaryRepository.findByCompanyIdAndPaymentPeriodAndCurrency(companyId, period, currency);
    }

    public Salary updateSalary(Long id, Salary salaryDetails) {
        Salary salary = getSalaryById(id);
        salary.setBaseSalary(salaryDetails.getBaseSalary());
        salary.setPaymentPeriod(salaryDetails.getPaymentPeriod());
        salary.setCurrency(salaryDetails.getCurrency());
        salary.setBonus(salaryDetails.getBonus());
        salary.setStocks(salaryDetails.getStocks());
        salary.setProfitSharing(salaryDetails.getProfitSharing());
        salary.setCommission(salaryDetails.getCommission());
        salary.setTips(salaryDetails.getTips());
        return salaryRepository.save(salary);
    }

    public void deleteSalary(Long id) {
        if (!salaryRepository.existsById(id)) {
            throw new RuntimeException("Salary not found with id: " + id);
        }
        salaryRepository.deleteById(id);
    }
} 