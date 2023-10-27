package com.ertikmen.service;


import com.ertikmen.dto.response.PostResponseDto;
import com.ertikmen.mapper.IPostMapper;
import com.ertikmen.repository.IPostRepository;
import com.ertikmen.repository.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private IPostRepository postRepository;


    public List<Post> getPosts() {

        return postRepository.findAll();
    }

    public Post findById(Long id) {
        Optional<Post> post=postRepository.findById(id);
        if (post.isEmpty()){
            throw new RuntimeException("Post Bulunamadı.");
        }
        return post.get();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post postInfo) {
        return postRepository.save(postInfo);
    }

    public String deletePost(Long id) {
        postRepository.deleteById(id);
        return "Post Silindi";
    }

    public List<PostResponseDto> findAllbyUserId(Long value) {
        List<Post> postList=postRepository.findAllByUserId(value);
        return IPostMapper.INSTANCE.toPostResponseDtos(postList);
    }

    public List<PostResponseDto> findAllByCategoryId(Long value) {
        List<Post> postList=postRepository.findAllByCategoryId(value);
        return IPostMapper.INSTANCE.toPostResponseDtos(postList);
    }

    public List<PostResponseDto> findAllByContentContainingIgnoreCase(String value) {
        List<Post> postList=postRepository.findAllByContentContainingIgnoreCase(value);
        return IPostMapper.INSTANCE.toPostResponseDtos(postList);
    }

    public List<PostResponseDto> orderByReleaseDate() {
        List<Post> postList=postRepository.orderByReleaseDate();
        return IPostMapper.INSTANCE.toPostResponseDtos(postList);

    }

    public List<PostResponseDto> filterByCategoryId(Long value) {
        List<Post> postList=postRepository.filterByCategoryId(value);
        return IPostMapper.INSTANCE.toPostResponseDtos(postList);
    }

    public List<PostResponseDto> filterByUserId(Long value) {
        List<Post> postList=postRepository.filterByUserId(value);
        return IPostMapper.INSTANCE.toPostResponseDtos(postList);
    }


}
