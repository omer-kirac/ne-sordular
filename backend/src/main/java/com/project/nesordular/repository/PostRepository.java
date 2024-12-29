package com.project.nesordular.repository;

import com.project.nesordular.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
    List<Post> findByOrderByCreatedAtDesc();
    List<Post> findByUserIdOrderByCreatedAtDesc(Long userId);
} 