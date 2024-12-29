package com.project.nesordular.config;

import com.project.nesordular.model.*;
import com.project.nesordular.model.enums.*;
import com.project.nesordular.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            UserRepository userRepository,
            CompanyRepository companyRepository,
            CompanyReviewRepository reviewRepository,
            SalaryRepository salaryRepository,
            InterviewRepository interviewRepository,
            PostRepository postRepository,
            CommentRepository commentRepository
    ) {
        return args -> {
            // Create Users
            if (userRepository.count() == 0) {
                User user1 = userRepository.save(new User(null, "john@example.com", "password123", Role.EMPLOYER));
                User user2 = userRepository.save(new User(null, "jane@example.com", "password456", Role.EMPLOYEE));
                User user3 = userRepository.save(new User(null, "bob@example.com", "password789", Role.STUDENT));

                // Create Companies
                Company company1 = companyRepository.save(new Company(null, "Tech Corp", 0.0, null, null, null));
                Company company2 = companyRepository.save(new Company(null, "Finance Inc", 0.0, null, null, null));

                // Create Reviews with Ratings
                Rating rating1 = new Rating(null, 4, 5, 4, 5, 4, 5, null);
                CompanyReview review1 = new CompanyReview(
                    null,
                    EmployeeStatus.CURRENT_EMPLOYEE,
                    "Great place to work",
                    "Good benefits, great culture",
                    "Work-life balance could be better",
                    "Consider flexible hours",
                    LocalDateTime.now(),
                    rating1,
                    company1,
                    user1
                );
                reviewRepository.save(review1);

                Rating rating2 = new Rating(null, 3, 4, 4, 3, 3, 4, null);
                CompanyReview review2 = new CompanyReview(
                    null,
                    EmployeeStatus.FORMER_EMPLOYEE,
                    "Decent workplace",
                    "Good salary",
                    "High pressure environment",
                    "Improve team communication",
                    LocalDateTime.now(),
                    rating2,
                    company2,
                    user2
                );
                reviewRepository.save(review2);

                // Create Salaries
                Salary salary1 = new Salary(
                    null,
                    10000.0,
                    PaymentPeriod.MONTHLY,
                    Currency.TRY,
                    20000.0,
                    5000.0,
                    10000.0,
                    null,
                    null,
                    company1,
                    user1
                );
                salaryRepository.save(salary1);

                Salary salary2 = new Salary(
                    null,
                    15000.0,
                    PaymentPeriod.MONTHLY,
                    Currency.TRY,
                    30000.0,
                    10000.0,
                    15000.0,
                    null,
                    null,
                    company2,
                    user2
                );
                salaryRepository.save(salary2);

                // Create Interviews
                Interview interview1 = new Interview(
                    null,
                    "3 rounds of technical interviews",
                    4,
                    OfferStatus.YES,
                    Arrays.asList("Algorithm question", "System design", "Behavioral"),
                    "LinkedIn",
                    "2 weeks",
                    LocalDate.now().minusMonths(1),
                    Arrays.asList(InterviewStyle.FACE_TO_FACE, InterviewStyle.TECHNICAL_TEST),
                    company1,
                    user1
                );
                interviewRepository.save(interview1);

                Interview interview2 = new Interview(
                    null,
                    "2 rounds: HR and Technical",
                    3,
                    OfferStatus.NO,
                    Arrays.asList("SQL questions", "Java basics"),
                    "Company website",
                    "1 week",
                    LocalDate.now().minusMonths(2),
                    Arrays.asList(InterviewStyle.FACE_TO_FACE),
                    company2,
                    user2
                );
                interviewRepository.save(interview2);

                // Create Posts
                Post post1 = new Post(
                    null,
                    "Yazılım sektöründe kariyer tavsiyeleri",
                    "Tecrübeli Yazılımcı",
                    false,
                    0,
                    LocalDateTime.now(),
                    Arrays.asList("https://example.com/image1.jpg"),
                    user1,
                    null
                );
                postRepository.save(post1);

                Post post2 = new Post(
                    null,
                    "Staj deneyimimi paylaşmak istiyorum",
                    null,
                    true,
                    0,
                    LocalDateTime.now(),
                    null,
                    user3,
                    null
                );
                postRepository.save(post2);

                // Create Comments
                Comment comment1 = new Comment(
                    null,
                    "Çok faydalı bir paylaşım olmuş, teşekkürler!",
                    "Jane",
                    false,
                    LocalDateTime.now(),
                    post1,
                    user2
                );
                commentRepository.save(comment1);

                Comment comment2 = new Comment(
                    null,
                    "Ben de benzer bir deneyim yaşadım",
                    null,
                    true,
                    LocalDateTime.now(),
                    post2,
                    user1
                );
                commentRepository.save(comment2);
            }
        };
    }
} 