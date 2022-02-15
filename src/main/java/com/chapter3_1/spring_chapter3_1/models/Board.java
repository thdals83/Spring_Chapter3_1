package com.chapter3_1.spring_chapter3_1.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title; //제목

    @Column(nullable = false)
    private String name; //작성자명

    @Column(nullable = false)
    private String content; //내용

    public Board(BoardRequestDTO requestDTO){
        this.title = requestDTO.getTitle();
        this.name = requestDTO.getName();
        this.content = requestDTO.getContent();
    }

    public void update(BoardRequestDTO requestDTO){
        this.title = requestDTO.getTitle();
        this.name = requestDTO.getName();
        this.content = requestDTO.getContent();
    }

}
