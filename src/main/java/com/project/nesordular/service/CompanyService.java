package com.project.nesordular.service;

import com.project.nesordular.model.Company;
import com.project.nesordular.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company company) {
        if (companyRepository.existsByName(company.getName())) {
            throw new RuntimeException("Company with this name already exists");
        }
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Company> getTopRatedCompanies() {
        return companyRepository.findAllOrderByRatingDesc();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
    }

    public List<Company> searchCompaniesByName(String name) {
        return companyRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public Company updateCompany(Long id, Company companyDetails) {
        Company company = getCompanyById(id);
        company.setName(companyDetails.getName());
        return companyRepository.save(company);
    }

    @Transactional
    public void updateCompanyRating(Long id, Double newRating) {
        Company company = getCompanyById(id);
        company.setAverageRating(newRating);
        companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found with id: " + id);
        }
        companyRepository.deleteById(id);
    }
} 