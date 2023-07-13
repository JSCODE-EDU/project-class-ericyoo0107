package com.example.junhyuk_board.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    @NotBlank(message =  "제목은 공백 없이 1글자 이상 15글자 이하여야 합니다.")
    @Size(min = 1, max = 15, message =  "제목은 공백 없이 1글자 이상 15글자 이하여야 합니다.")
    private String title;
    @NotNull(message = "내용은 1글자 이상 1000글자 이하여야 합니다.")
    @Size(min = 1, max = 1000, message = "내용은 1글자 이상 1000글자 이하여야 합니다.")
    private String content;
    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public Post DtoToEntity() {
        Post post = new Post(id, title, content);
        return post;
    }
}
