package com.example.junhyuk_board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public Post DtoToEntity() {
        Post post = new Post(id, title, content);
        return post;
    }
}
