package com.chapter3_1.spring_chapter3_1.controller;


import com.chapter3_1.spring_chapter3_1.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentRestController {
    private final CommentRepository commentRepository;

    //댓글 입력
    @PostMapping("/api/comment")
    public Comment createComment(@RequestBody CommentRequestDTO requestDTO){
        Comment comment = new Comment(requestDTO);
        return  commentRepository.save(comment);
    }

    //댓글 보기
    @GetMapping("/api/comment/{id}")
    public List<Comment> getComment(@PathVariable String id){
        System.out.println(id);
        return commentRepository.findAllByBoardid(id);
    }

    //댓글 삭제
    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }

    //댓글 수정

//    public List<Comment> getComment(){
//        return commentRepository.findAllByOrderByModifiedAtDesc();
//    }
}