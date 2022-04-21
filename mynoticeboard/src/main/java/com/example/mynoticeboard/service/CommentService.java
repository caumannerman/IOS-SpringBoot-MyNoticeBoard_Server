package com.example.mynoticeboard.service;

import com.example.mynoticeboard.dto.CommentDto;
import com.example.mynoticeboard.entity.Comment;
import com.example.mynoticeboard.entity.Post;
import com.example.mynoticeboard.repository.CommentRepository;
import com.example.mynoticeboard.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public List<CommentDto> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);

        List<CommentDto> dtos = comments
                .stream()
                .map(comment -> comment.EntityToDto())
                .collect(Collectors.toList());

        return dtos;
    }

    //댓글 삭제
    @Transactional
    public CommentDto delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상이 없습니다ㅏ."));

        commentRepository.delete(comment);

        return comment.EntityToDto();
    }

    //댓글 생성
    @Transactional
    public CommentDto create(Long postId, CommentDto dto) {
        //게시글 조회 및 예외 발생
        // 받아온 articleID가 유효하지 않은 경우
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));

        //댓글 Entity 생성
        //static 메서드 사용해서 Comment 객체 생성 - 받아온 dto의 내용을 해당 article에 달린 COmment가 되도록 만들어준다
        Comment comment = Comment.createComment(dto,post);

        //댓글 Entity를 DB로 저장
        Comment created = commentRepository.save(comment);

        //DTO로 변경하여 반환
        return created.EntityToDto();
    }

    public CommentDto update(Long id, CommentDto dto) {
        //댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));

        //댓글 수정
        target.patch(dto);

        //DB로 갱신
        Comment updated = commentRepository.save(target);

        //댓글 엔티티를 DTO로 변환 및 반환
        return updated.EntityToDto();
    }
}
