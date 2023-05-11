package com.example.junhyuk_board.service;

import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //의존성 주입을 대체
public class PostService {
    private final PostRepository postRepository;

    public Post DtoToEntity(PostDTO postDTO)
    {
        Post post = new Post(postDTO.getId(), postDTO.getTitle(), postDTO.getContent(), postDTO.getCreateTime());
        return post;
    }

    public void writePost(PostDTO postDTO)
    {
        Post post = DtoToEntity(postDTO);
        postRepository.save(post);
    }
}
