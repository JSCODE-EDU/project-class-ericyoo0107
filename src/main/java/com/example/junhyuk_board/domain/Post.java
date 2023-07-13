package com.example.junhyuk_board.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity를 사용하면 auto_increment됨
    private Long id;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

//    @Temporal(TemporalType.TIMESTAMP) // 이 어노테이션을 붙이면 Postman에서 따로 바디에 createTime 값을 넣지 않아도 되는지? =>nullable이어서 그런듯
//    private Date createTime; //util의 date는 시분초까지 찍힌다
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updateTime;


    public PostDTO EntityToDTO() {
        PostDTO postDTO = new PostDTO(id, title, content, getCreatedDate(), getModifiedDate());
        return postDTO;
    }

}
