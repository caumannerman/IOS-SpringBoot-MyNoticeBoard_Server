package com.example.mynoticeboard.entity;


import com.example.mynoticeboard.dto.CommentDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // 해당 댓글 엔티티 여러개가 하나의 Article에 연관
    @JoinColumn(name = "post")
    private Post post;

    @Column
    private String user_nickname;

    @Column
    private String content;

    @Column
    private String time;

    public static Comment createComment(CommentDto dto, Post post) {

        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야합니다!");
        if (dto.getPost_id() != post.getId())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못되었습니다");

        return new Comment(
                dto.getId(),
                post,
                dto.getUser_nickname(),
                dto.getContent(),
                dto.getTime()
        );
    }

//    @Column
//    private Boolean isSecret;

    public CommentDto EntityToDto(){
        return new CommentDto(
                this.getId(),
                this.getPost().getId(),
                this.getUser_nickname(),
                this.getContent(),
                this.getTime()
        );
    }

    public void patch(CommentDto dto) {
        //예외 발생
        if(this.id != dto.getId()) throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력되었습니다!");

        //객체를 갱신
        if (dto.getContent() != null)
            this.content = dto.getContent();
        if (dto.getTime() != null)
            this.time = dto.getTime();
    }
}
