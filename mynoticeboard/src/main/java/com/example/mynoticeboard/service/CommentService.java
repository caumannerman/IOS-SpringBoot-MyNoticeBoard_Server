package com.example.mynoticeboard.service;

import com.example.mynoticeboard.entity.Comment;
import com.example.mynoticeboard.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        return comments;
    }
}
