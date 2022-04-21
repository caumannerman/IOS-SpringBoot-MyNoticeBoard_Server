package com.example.mynoticeboard.controller;

import com.example.mynoticeboard.dto.CommentDto;
import com.example.mynoticeboard.entity.Comment;
import com.example.mynoticeboard.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentApiController {

    @Autowired
    private CommentService commentService;

    //게시글에 달린 댓글 전체 조회
    @GetMapping("/api/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getAllComments(@PathVariable Long postId){
        List<CommentDto> dtos = commentService.getAllComments(postId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id){
        // 서비스에게 위임
        CommentDto updatedDto = commentService.delete(id);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }




}
