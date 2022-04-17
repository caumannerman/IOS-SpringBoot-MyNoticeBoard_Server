package com.example.mynoticeboard.controller;

import com.example.mynoticeboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    @Autowired
    private PostService postService;


}
