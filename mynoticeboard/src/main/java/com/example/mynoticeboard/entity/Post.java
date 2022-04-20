package com.example.mynoticeboard.entity;


import com.example.mynoticeboard.dto.PostDto;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String time;

    @Column
    private String user_nickname;

    @Column
    private String hashtag;

    public void patch(PostDto dto) {
        if (dto.getTitle() != null)
            this.title = dto.getTitle();
        if (dto.getContent() != null)
            this.content = dto.getTitle();
        if (dto.getHashtag() != null){
            this.hashtag = dto.getHashtag();
        }

    }
}
