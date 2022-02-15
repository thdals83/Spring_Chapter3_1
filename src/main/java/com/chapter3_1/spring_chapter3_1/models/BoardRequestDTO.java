package com.chapter3_1.spring_chapter3_1.models;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class BoardRequestDTO {

    private String title; //제목
    private String name; //작성자명
    private String content; //내용
}
