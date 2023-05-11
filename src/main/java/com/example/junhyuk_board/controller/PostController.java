package com.example.junhyuk_board.controller;

import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("write")
    public void writePost(@RequestBody PostDTO postDTO)
    {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        postDTO.setCreateTime(createTime);
        postService.writePost(postDTO);
    }
}
