package com.example.junhyuk_board.service;

import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //의존성 주입을 대체
public class PostService {
    private final PostRepository postRepository;

    public void writePost(PostDTO postDTO)
    {
        Post post = postDTO.DtoToEntity();
        postRepository.save(post); //save 하면 자동으로 테이블도 생기는게 레전드
    }

    public List<PostDTO> showPosts() // 이거 DTO말고 entity 통으로 반환했는데 괜찮을까..?
    {
        List<Post> postEntityList = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : postEntityList) {
            PostDTO postDTO = post.EntityToDTO();
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }

    public PostDTO findPostByID(Long id)
    {
        Optional<Post> post = postRepository.findById(id);
        Post naturalPost = post.get();
        PostDTO postDTO = naturalPost.EntityToDTO();
        return postDTO;
    }

    public PostDTO updatePostByID(Long id, String newTitle, String newContent)
    {
        Optional<Post> post = postRepository.findById(id);
        Post naturalPost = post.get();
        naturalPost.setTitle(newTitle);
        naturalPost.setContent(newContent);
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        naturalPost.setUpdateTime(updateTime);
        postRepository.save(naturalPost);
        PostDTO updatePost = naturalPost.EntityToDTO();
        return updatePost;
    }

    public void deletePostByID(Long id)
    {
        postRepository.deleteById(id);
    }
}
