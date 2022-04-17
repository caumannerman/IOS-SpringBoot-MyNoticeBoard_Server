package com.example.mynoticeboard.repository;

import com.example.mynoticeboard.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

   @Override
   List<Post> findAll();
}
