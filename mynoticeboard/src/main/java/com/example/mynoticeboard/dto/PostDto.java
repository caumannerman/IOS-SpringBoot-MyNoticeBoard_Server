package com.example.mynoticeboard.dto;


import com.example.mynoticeboard.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String time;
    private String user_nickname;
    private String hashtag;

    // dto를 Entity로
    public Post toPost() {
        return new Post(id, title, content, time, user_nickname, hashtag);
    }

}
