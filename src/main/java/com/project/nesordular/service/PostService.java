package com.project.nesordular.service;

import com.project.nesordular.model.Post;
import com.project.nesordular.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Transactional
    public Post updatePost(Long id, Post postDetails) {
        Post post = getPostById(id);
        post.setContent(postDetails.getContent());
        post.setAuthorName(postDetails.getAuthorName());
        post.setAnonymous(postDetails.isAnonymous());
        post.setMediaUrls(postDetails.getMediaUrls());
        return postRepository.save(post);
    }

    @Transactional
    public Post likePost(Long id) {
        Post post = getPostById(id);
        post.setLikeCount(post.getLikeCount() + 1);
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post not found with id: " + id);
        }
        postRepository.deleteById(id);
    }
} 