package com.project.nesordular.controller;

import com.project.nesordular.model.Interview;
import com.project.nesordular.model.enums.OfferStatus;
import com.project.nesordular.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        return ResponseEntity.ok(interviewService.createInterview(interview));
    }

    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        return ResponseEntity.ok(interviewService.getAllInterviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable Long id) {
        return ResponseEntity.ok(interviewService.getInterviewById(id));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Interview>> getInterviewsByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.ok(interviewService.getInterviewsByCompanyId(companyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Interview>> getInterviewsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(interviewService.getInterviewsByUserId(userId));
    }

    @GetMapping("/company/{companyId}/status")
    public ResponseEntity<List<Interview>> getInterviewsByCompanyAndStatus(
            @PathVariable Long companyId,
            @RequestParam OfferStatus status) {
        return ResponseEntity.ok(interviewService.getInterviewsByCompanyAndOfferStatus(companyId, status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interview> updateInterview(@PathVariable Long id, @RequestBody Interview interview) {
        return ResponseEntity.ok(interviewService.updateInterview(id, interview));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long id) {
        interviewService.deleteInterview(id);
        return ResponseEntity.ok().build();
    }
} 