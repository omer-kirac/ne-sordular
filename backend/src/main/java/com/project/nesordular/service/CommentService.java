package com.project.nesordular.service;

import com.project.nesordular.model.Comment;
import com.project.nesordular.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    @Transactional
    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = getCommentById(id);
        comment.setContent(commentDetails.getContent());
        comment.setAuthorName(commentDetails.getAuthorName());
        comment.setAnonymous(commentDetails.isAnonymous());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found with id: " + id);
        }
        commentRepository.deleteById(id);
    }
} 