package com.example.mynoticeboard.service;

import com.example.mynoticeboard.dto.PostDto;
import com.example.mynoticeboard.entity.Post;
import com.example.mynoticeboard.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 저장된 모든 Posts를 가져옴
    public List<Post> getAllPosts() {
        List<Post> postList =  postRepository.findAll();
        log.info("mymy" + postList.toString());
        return postList;
    }

    //하나의 Post를 가져옴
    public Post getOnePost(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    // Post 생성
    @Transactional
    public Post create(PostDto dto) {
        Post post = dto.toEntity();
        //post에는 id가 있으면 안됨
        if ( post.getId() != null){
            return null;
        }
        return postRepository.save(post);
    }

    // Post 삭제
    @Transactional
    public Post delete(Long id) {
        //해당 id를 가진 Post가 있는지 확인
       Post target = postRepository.findById(id).orElse(null);
       //댓글 삭제
        postRepository.delete(target);

        return target;
    }

}
