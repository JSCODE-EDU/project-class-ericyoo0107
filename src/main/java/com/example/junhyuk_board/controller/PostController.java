package com.example.junhyuk_board.controller;

import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {
    private final PostService postService;
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @PostMapping("write")
    public void writePost(@RequestBody PostDTO postDTO)
    {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        postDTO.setCreateTime(createTime);
        postService.writePost(postDTO);
        logger.info("게시물 저장!");
    }

    @GetMapping("")
    public List<Post> showPosts()
    {
        return postService.showPosts();
    }
}