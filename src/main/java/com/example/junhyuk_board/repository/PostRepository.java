package com.example.junhyuk_board.repository;

import com.example.junhyuk_board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findTop100ByOrderByModifiedDate();
    List<Post> findTop100ByTitleContainingOrderByModifiedDate(String Title);
}
