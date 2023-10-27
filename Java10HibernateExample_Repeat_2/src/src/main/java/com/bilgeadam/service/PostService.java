package com.bilgeadam.service;

import com.bilgeadam.repository.ICrud;
import com.bilgeadam.repository.PostRepository;
import com.bilgeadam.repository.entity.Post;

import java.util.List;
import java.util.Optional;

public class PostService implements ICrud<Post> {

    private PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    @Override
    public Post save(Post post) {
        return  postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }
}
