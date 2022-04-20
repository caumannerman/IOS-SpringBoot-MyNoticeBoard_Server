package com.example.mynoticeboard.repository;

import com.example.mynoticeboard.entity.Comment;
import com.example.mynoticeboard.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 게시물 id로 게시물에 달린 모든 댓글 조회
    @Query(value = "SELECT * FROM comment WHERE post = :postId", nativeQuery = true)
    List<Comment> findAllByPostId(Long postId);
}
