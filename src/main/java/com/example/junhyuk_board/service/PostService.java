package com.example.junhyuk_board.service;

import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //의존성 주입을 대체
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public void writePost(PostDTO postDTO) {
        Post post = postDTO.DtoToEntity();
        postRepository.save(post);
    }

    public List<PostDTO> showPosts()
    {
        List<Post> postList = postRepository.findTop100ByOrderByModifiedDate();
        List<PostDTO> postDTOList = postList.stream().map(post -> post.EntityToDTO()).collect(Collectors.toList());
        return postDTOList;
    }

    public PostDTO findPostByID(Long id) {
        Optional<Post> post = postRepository.findById(id);
        Post naturalPost = post.get();
        PostDTO postDTO = naturalPost.EntityToDTO();
        return postDTO;
    }

    public PostDTO updatePostByID(Long id, String newTitle, String newContent) {
        Optional<Post> post = postRepository.findById(id);
        Post naturalPost = post.get();
        naturalPost.setTitle(newTitle);
        naturalPost.setContent(newContent);
        postRepository.save(naturalPost);
        PostDTO updatePost = naturalPost.EntityToDTO();
        return updatePost;
    }

    public void deletePostByID(Long id) {
        postRepository.deleteById(id);
    }

    public List<PostDTO> showPostBySearch(String Title)
    {
        List<Post> postList = postRepository.findTop100ByTitleContainingOrderByModifiedDate(Title);
        List<PostDTO> postDTOList = postList.stream().map(post -> post.EntityToDTO()).collect(Collectors.toList());
        return postDTOList;
    }
}
