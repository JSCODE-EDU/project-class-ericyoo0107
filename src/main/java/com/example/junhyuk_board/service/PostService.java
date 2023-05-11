package com.example.junhyuk_board.service;

import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        postRepository.save(post); //save 하면 자동으로 테이블도 생기는게 레전드
    }

    public List<Post> showPosts() // 이거 DTO말고 entity 통으로 반환했는데 괜찮을까..?
    {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

}
