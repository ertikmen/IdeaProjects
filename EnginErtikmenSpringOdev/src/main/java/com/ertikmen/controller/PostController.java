package com.ertikmen.controller;


import com.ertikmen.dto.response.PostResponseDto;
import com.ertikmen.repository.entity.Post;
import com.ertikmen.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ertikmen.constant.RestApiUrl.*;

@RestController
@RequestMapping(POST)
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/get_posts")
    public ResponseEntity<List<Post>> postList(){

        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/find_post_by_id/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping("/post_save")
    public ResponseEntity<?> createPost(String title,String content){
        Post post=Post.builder().title(title).content(content).build();
        try {
            postService.createPost(post);
            return ResponseEntity.ok(post);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Post Oluşturulamadı.");
        }
    }
    @PutMapping("/update_post_by_id/{id}")
    public Post updatePost(@PathVariable Long id,@RequestBody Post post){
        Post postInfo=postService.findById(id);
        if (postInfo!=null){
            postInfo.setId(id);
            postInfo.setTitle(post.getTitle());
            postInfo.setContent(post.getContent());
            postInfo.setReleaseDate(post.getReleaseDate());
            postInfo.setUserId(post.getUserId());
            postInfo.setCategoryId(post.getCategoryId());
            return postService.updatePost(postInfo);
        }
        return null;
    }

    @DeleteMapping("/delete_post_by_id/{id}")
    public String deletePost(@PathVariable Long id){

        Post postInfo=postService.findById(id);
        if (postInfo!=null){
            return postService.deletePost(id);
        }
        return null;
    }

    @GetMapping("/get_posts/user/{id}")
    public ResponseEntity<List<PostResponseDto>> findAllbyUserId(Long value){
        return ResponseEntity.ok(postService.findAllbyUserId(value));
    }

    @GetMapping("/get_posts/category/{id}")
    public ResponseEntity<List<PostResponseDto>> findAllByCategoryId(Long value){
        return ResponseEntity.ok(postService.findAllByCategoryId(value));
    }

    @GetMapping("/search_by_word")
    public  ResponseEntity<List<PostResponseDto>> findAllByContentContainingIgnoreCase(String value){
        return ResponseEntity.ok(postService.findAllByContentContainingIgnoreCase(value));
    }

    @GetMapping("/order_by_releasedate")
    public ResponseEntity<List<PostResponseDto>> orderByReleaseDate(){
        return ResponseEntity.ok(postService.orderByReleaseDate());
    }
    @GetMapping("/filter_by_category_id")
    public ResponseEntity<List<PostResponseDto>> filterByCategoryId(Long value){
        return ResponseEntity.ok(postService.filterByCategoryId(value));
    }
    @GetMapping("/filter_by_user_id")
    public ResponseEntity<List<PostResponseDto>> filterByUserId(Long value){
        return ResponseEntity.ok(postService.filterByUserId(value));
    }

}
