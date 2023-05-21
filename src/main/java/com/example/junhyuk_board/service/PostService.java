package com.example.junhyuk_board.service;

import com.example.junhyuk_board.domain.Post;
import com.example.junhyuk_board.domain.PostDTO;
import com.example.junhyuk_board.repository.PostRepository;
import com.example.junhyuk_board.Exception.ErrorCodes;
import com.example.junhyuk_board.Exception.Customs.NoPostError;
import com.example.junhyuk_board.Exception.Customs.UnableFormError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public List<PostDTO> showPosts() {
        List<Post> postList = postRepository.findTop100ByOrderByModifiedDate();
        List<PostDTO> postDTOList = postList.stream().map(post -> post.EntityToDTO()).collect(Collectors.toList());
        return postDTOList;
    }

    public Post findPostByID(Long id) {
        if (!postRepository.existsById(id)) {
            throw new NoPostError(ErrorCodes.NOT_FOUND);
        }
        return postRepository.findById(id).get();
    }

    public Post updatePostByID(Long id, String newTitle, String newContent) {
        Post post = postRepository.findById(id).get();
        post.setTitle(newTitle);
        post.setContent(newContent);
        postRepository.save(post);
        return post;
    }

    public void deletePostByID(Long id) {
        if (!postRepository.existsById(id)) {
            throw new NoPostError(ErrorCodes.NOT_FOUND);
        }
        postRepository.deleteById(id);
    }

    public List<PostDTO> showPostBySearch(String Title) {
        if (Title.length() < 1) {
            throw new UnableFormError(ErrorCodes.BAD_REQUEST);
        }
        List<Post> postList = postRepository.findTop100ByTitleContainingOrderByModifiedDate(Title);
        List<PostDTO> postDTOList = postList.stream().map(post -> post.EntityToDTO()).collect(Collectors.toList());
        return postDTOList;
    }
}
