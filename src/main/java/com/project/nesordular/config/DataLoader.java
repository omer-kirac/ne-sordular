package com.project.nesordular.config;

import com.project.nesordular.model.Role;
import com.project.nesordular.model.User;
import com.project.nesordular.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User(null, "john@example.com", "password123", Role.EMPLOYER));
                userRepository.save(new User(null, "jane@example.com", "password456", Role.EMPLOYEE));
                userRepository.save(new User(null, "bob@example.com", "password789", Role.STUDENT));
            }
        };
    }
} 