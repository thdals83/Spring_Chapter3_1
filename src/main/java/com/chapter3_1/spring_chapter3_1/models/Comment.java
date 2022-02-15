package com.chapter3_1.spring_chapter3_1.models;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String boardid; //제목

    @Column(nullable = false)
    private String commentcontents; //작성자명

    public Comment(CommentRequestDTO requestDTO){
        this.boardid = requestDTO.getBoardid();
        this.commentcontents = requestDTO.getComment_contents();
    }

    public void update(CommentreplaceDTO commentreplaceDTO){
        this.commentcontents = commentreplaceDTO.getComment_contents();
    }


}
