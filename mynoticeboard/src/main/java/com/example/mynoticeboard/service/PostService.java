package com.example.mynoticeboard.service;

import com.example.mynoticeboard.entity.Post;
import com.example.mynoticeboard.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 저장된 모든 Posts를 가져옴
    public List<Post> getAllPosts() {
        List<Post> postList =  postRepository.findAll();
        log.info("mymy" + postList.toString());
        return postList;
    }

    //하나의 Post를 가져옴
    public Post getOnePost(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
