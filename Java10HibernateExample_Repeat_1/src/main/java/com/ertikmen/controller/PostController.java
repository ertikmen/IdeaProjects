package com.ertikmen.controller;

import com.ertikmen.repository.ICrud;
import com.ertikmen.repository.entity.Post;
import com.ertikmen.service.PostService;

import java.util.List;
import java.util.Optional;

public class PostController implements ICrud<Post> {

    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    @Override
    public Post save(Post post) {
        return postService.save(post);
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long Id) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(Long Id) {
        return Optional.empty();
    }
}
