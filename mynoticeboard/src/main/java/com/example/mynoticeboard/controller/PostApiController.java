package com.example.mynoticeboard.controller;

import com.example.mynoticeboard.dto.PostDto;
import com.example.mynoticeboard.entity.Post;
import com.example.mynoticeboard.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //새 게시글 등록
    @PostMapping("/api/posts")
    public ResponseEntity<Post> create(@RequestBody PostDto dto){
        Post created = postService.create(dto);
        return ( created != null) ?
            ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity<Post> delete(@PathVariable Long id){
        Post deleted = postService.delete(id);

        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    // 게시글 수정

}
