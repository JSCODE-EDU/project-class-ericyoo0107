package com.example.junhyuk_board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private Date createTime;
}
