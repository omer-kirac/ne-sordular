package com.project.nesordular.controller;

import com.project.nesordular.model.Salary;
import com.project.nesordular.model.enums.PaymentPeriod;
import com.project.nesordular.model.enums.Currency;
import com.project.nesordular.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping
    public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
        return ResponseEntity.ok(salaryService.createSalary(salary));
    }

    @GetMapping
    public ResponseEntity<List<Salary>> getAllSalaries() {
        return ResponseEntity.ok(salaryService.getAllSalaries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
        return ResponseEntity.ok(salaryService.getSalaryById(id));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Salary>> getSalariesByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.ok(salaryService.getSalariesByCompanyId(companyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Salary>> getSalariesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(salaryService.getSalariesByUserId(userId));
    }

    @GetMapping("/company/{companyId}/average")
    public ResponseEntity<Double> getAverageBaseSalary(
            @PathVariable Long companyId,
            @RequestParam PaymentPeriod period,
            @RequestParam Currency currency) {
        return ResponseEntity.ok(salaryService.getAverageBaseSalary(companyId, period, currency));
    }

    @GetMapping("/company/{companyId}/filter")
    public ResponseEntity<List<Salary>> getSalariesByCompanyAndPeriodAndCurrency(
            @PathVariable Long companyId,
            @RequestParam PaymentPeriod period,
            @RequestParam Currency currency) {
        return ResponseEntity.ok(salaryService.getSalariesByCompanyAndPeriodAndCurrency(companyId, period, currency));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @RequestBody Salary salary) {
        return ResponseEntity.ok(salaryService.updateSalary(id, salary));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.ok().build();
    }
} 