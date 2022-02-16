package com.chapter3_1.spring_chapter3_1.models;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class CommentRequestDTO {
    private String boardid; //제목
    private String comment_contents; //작성 내용


}
