package com.example.junhyuk_board.controller;

import com.example.junhyuk_board.Exception.Customs.UnableFormError;
import com.example.junhyuk_board.Exception.ErrorCodes;
import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {
    private final PostService postService;
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @PostMapping("write")
    public void writePost(@Valid @RequestBody PostDTO postDTO, BindingResult result) {
        if (result.hasErrors()) {
            throw new UnableFormError(ErrorCodes.BAD_REQUEST);
        }
        postService.writePost(postDTO);
        logger.info("게시물 저장!");
    }

    @GetMapping("")
    public List<PostDTO> showPosts() { //result로 감싸서 반환하면 나중에 유지보수 하기 편함
        return postService.showPosts();
    }

    @GetMapping("{id}")
    public PostDTO showPostByID(@PathVariable Long id) {
        Post post = postService.findPostByID(id);
        return post.EntityToDTO();
    }

    @PatchMapping("{id}")
    public PostDTO updatePostByID(@PathVariable Long id, @Valid @RequestBody PostDTO updatePost, BindingResult result) {
        if (result.hasErrors()) {
            throw new UnableFormError(ErrorCodes.BAD_REQUEST);
        }
        return postService.updatePostByID(id, updatePost.getTitle(), updatePost.getContent()).EntityToDTO();
    }

    @DeleteMapping("{id}")
    public void deletePostByID(@PathVariable Long id) {
        postService.deletePostByID(id);
    }

    @GetMapping("/search")
    public List<PostDTO> showPostBySearch(@Valid @RequestParam String title) {
        List<PostDTO> postDTOList = postService.showPostBySearch(title);
        return postDTOList;
    }
}
