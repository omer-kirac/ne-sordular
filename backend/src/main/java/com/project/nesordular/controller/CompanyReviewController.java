package com.project.nesordular.controller;

import com.project.nesordular.model.CompanyReview;
import com.project.nesordular.service.CompanyReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class CompanyReviewController {

    private final CompanyReviewService reviewService;

    @Autowired
    public CompanyReviewController(CompanyReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<CompanyReview> createReview(@RequestBody CompanyReview review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping
    public ResponseEntity<List<CompanyReview>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyReview> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<CompanyReview>> getReviewsByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.ok(reviewService.getReviewsByCompanyId(companyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CompanyReview>> getReviewsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyReview> updateReview(@PathVariable Long id, @RequestBody CompanyReview review) {
        return ResponseEntity.ok(reviewService.updateReview(id, review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }
} 