package com.example.mynoticeboard.repository;

import com.example.mynoticeboard.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {


}
