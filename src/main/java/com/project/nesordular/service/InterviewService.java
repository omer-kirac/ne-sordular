package com.project.nesordular.service;

import com.project.nesordular.model.Interview;
import com.project.nesordular.model.enums.OfferStatus;
import com.project.nesordular.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    @Autowired
    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found with id: " + id));
    }

    public List<Interview> getInterviewsByCompanyId(Long companyId) {
        return interviewRepository.findByCompanyIdOrderByInterviewDateDesc(companyId);
    }

    public List<Interview> getInterviewsByUserId(Long userId) {
        return interviewRepository.findByUserId(userId);
    }

    public List<Interview> getInterviewsByCompanyAndOfferStatus(Long companyId, OfferStatus offerStatus) {
        return interviewRepository.findByCompanyIdAndOfferStatus(companyId, offerStatus);
    }

    public Interview updateInterview(Long id, Interview interviewDetails) {
        Interview interview = getInterviewById(id);
        interview.setProcessDescription(interviewDetails.getProcessDescription());
        interview.setDifficultyRating(interviewDetails.getDifficultyRating());
        interview.setOfferStatus(interviewDetails.getOfferStatus());
        interview.setQuestions(interviewDetails.getQuestions());
        interview.setApplicationMethod(interviewDetails.getApplicationMethod());
        interview.setProcessDuration(interviewDetails.getProcessDuration());
        interview.setInterviewDate(interviewDetails.getInterviewDate());
        interview.setInterviewStyles(interviewDetails.getInterviewStyles());
        return interviewRepository.save(interview);
    }

    public void deleteInterview(Long id) {
        if (!interviewRepository.existsById(id)) {
            throw new RuntimeException("Interview not found with id: " + id);
        }
        interviewRepository.deleteById(id);
    }
} 