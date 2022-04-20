package com.example.mynoticeboard.service;

import com.example.mynoticeboard.dto.CommentDto;
import com.example.mynoticeboard.entity.Comment;
import com.example.mynoticeboard.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDto> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);

        List<CommentDto> dtos = comments
                .stream()
                .map(comment -> comment.EntityToDto())
                .collect(Collectors.toList());

        return dtos;
    }
}
