package com.project.nesordular.repository;

import com.project.nesordular.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostIdOrderByCreatedAtDesc(Long postId);
    List<Comment> findByUserIdOrderByCreatedAtDesc(Long userId);
} 