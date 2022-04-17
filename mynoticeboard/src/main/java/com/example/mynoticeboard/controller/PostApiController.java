package com.example.mynoticeboard.controller;

import com.example.mynoticeboard.entity.Post;
import com.example.mynoticeboard.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class PostApiController {

    @Autowired
    private PostService postService;

    //전체 게시글 조회
    @GetMapping("/api/posts")
    public List<Post> getAllPosts(){
        List<Post> postList =  postService.getAllPosts();
        log.info("mymy in controller" + postList.toString());
        return postList;
    }

    //단일 게시글 조회
    @GetMapping("/api/posts/{id}")
    public ResponseEntity<Post> getOnePost(@PathVariable Long id){
        Post post =  postService.getOnePost(id);
        log.info("mymy in controller" + post.toString());
        //해당 id 게시글이 없는 경우
        return (post != null)?
            ResponseEntity.status(HttpStatus.OK).body(post) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


}
