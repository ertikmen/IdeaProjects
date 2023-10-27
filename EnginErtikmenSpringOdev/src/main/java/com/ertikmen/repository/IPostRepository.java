package com.ertikmen.repository;

import com.ertikmen.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPostRepository extends JpaRepository<Post,Long>{


    List<Post> findAllByUserId(Long value);


    List<Post> findAllByCategoryId(Long value);

    List<Post> findAllByContentContainingIgnoreCase(String value);


    @Query("select p from Post p order by p.releaseDate")
    List<Post> orderByReleaseDate();

    @Query("select p from Post p where p.categoryId=?1")
    List<Post> filterByCategoryId(Long value);

    @Query("select p from Post p where p.userId=?1")
    List<Post> filterByUserId(Long value);



}
