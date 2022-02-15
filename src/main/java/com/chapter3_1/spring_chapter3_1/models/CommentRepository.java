package com.chapter3_1.spring_chapter3_1.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();

    List<Comment> findAllByBoardid(String id);

//    Long findByBoard_id(Long id);

//    List<Comment> findByBoard_id(Long name);

}
