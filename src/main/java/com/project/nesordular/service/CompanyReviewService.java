package com.project.nesordular.service;

import com.project.nesordular.model.CompanyReview;
import com.project.nesordular.model.Company;
import com.project.nesordular.repository.CompanyReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyReviewService {

    private final CompanyReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Autowired
    public CompanyReviewService(CompanyReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Transactional
    public CompanyReview createReview(CompanyReview review) {
        CompanyReview savedReview = reviewRepository.save(review);
        updateCompanyAverageRating(review.getCompany().getId());
        return savedReview;
    }

    public List<CompanyReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    public CompanyReview getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }

    public List<CompanyReview> getReviewsByCompanyId(Long companyId) {
        return reviewRepository.findByCompanyIdOrderByCreatedAtDesc(companyId);
    }

    public List<CompanyReview> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Transactional
    public CompanyReview updateReview(Long id, CompanyReview reviewDetails) {
        CompanyReview review = getReviewById(id);
        review.setPros(reviewDetails.getPros());
        review.setCons(reviewDetails.getCons());
        review.setAdviceToManagement(reviewDetails.getAdviceToManagement());
        review.setRating(reviewDetails.getRating());
        
        CompanyReview updatedReview = reviewRepository.save(review);
        updateCompanyAverageRating(review.getCompany().getId());
        return updatedReview;
    }

    @Transactional
    public void deleteReview(Long id) {
        CompanyReview review = getReviewById(id);
        Long companyId = review.getCompany().getId();
        reviewRepository.deleteById(id);
        updateCompanyAverageRating(companyId);
    }

    private void updateCompanyAverageRating(Long companyId) {
        List<CompanyReview> reviews = reviewRepository.findByCompanyId(companyId);
        if (!reviews.isEmpty()) {
            double averageRating = reviews.stream()
                    .mapToDouble(review -> calculateAverageRating(review))
                    .average()
                    .orElse(0.0);
            companyService.updateCompanyRating(companyId, averageRating);
        }
    }

    private double calculateAverageRating(CompanyReview review) {
        return (review.getRating().getCareerOpportunities() +
                review.getRating().getBenefits() +
                review.getRating().getCultureAndValues() +
                review.getRating().getDiversityAndInclusion() +
                review.getRating().getSeniorManagement() +
                review.getRating().getWorkLifeBalance()) / 6.0;
    }
} 