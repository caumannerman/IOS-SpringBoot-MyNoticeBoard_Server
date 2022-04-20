package com.example.mynoticeboard.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {

    private Long id;
    private Long post_id;
    private String user_nickname;
    private String content;
    private String time;

}
