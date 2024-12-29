package com.project.nesordular.model;

import com.project.nesordular.model.enums.OfferStatus;
import com.project.nesordular.model.enums.InterviewStyle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "interviews")
public class Interview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 2000)
    private String processDescription;
    
    @Column(nullable = false)
    private Integer difficultyRating; // 1-5
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;
    
    @ElementCollection
    @CollectionTable(name = "interview_questions")
    private List<String> questions = new ArrayList<>();
    
    @Column(nullable = false)
    private String applicationMethod;
    
    @Column(nullable = false)
    private String processDuration;
    
    @Column(nullable = false)
    private LocalDate interviewDate;
    
    @ElementCollection
    @CollectionTable(name = "interview_styles")
    @Enumerated(EnumType.STRING)
    private List<InterviewStyle> interviewStyles = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
} 