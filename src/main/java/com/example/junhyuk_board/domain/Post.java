package com.example.junhyuk_board.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity를 사용하면 auto_increment됨
    private Long id;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Temporal(TemporalType.TIMESTAMP) // 이 어노테이션을 붙이면 Postman에서 따로 바디에 createTime 값을 넣지 않아도 되는지? =>nullable이어서 그런듯
    private Date createTime; //util의 date는 시분초까지 찍힌다
}
