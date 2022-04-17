package com.example.mynoticeboard.dto;


import com.example.mynoticeboard.entity.Post;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String time;
    private String user_nickname;
    private String hashtag;

    // dto를 Entity로
    public Post toEntity() {
        return new Post(id, title, content, time, user_nickname, hashtag);
    }

}
