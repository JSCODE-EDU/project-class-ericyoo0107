package com.example.junhyuk_board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private Date createTime;

    private Date updateTime;

    public Post DtoToEntity() {
        Post post = new Post(id, title, content, createTime, updateTime);
        return post;
    }
}
