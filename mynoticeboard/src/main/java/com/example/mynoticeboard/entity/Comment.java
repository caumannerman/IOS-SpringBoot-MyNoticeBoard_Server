package com.example.mynoticeboard.entity;


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
    private String nickname;

    @Column
    private String content;

    @Column
    private String time;

//    @Column
//    private Boolean isSecret;

}
