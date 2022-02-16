package com.chapter3_1.spring_chapter3_1.service;

import com.chapter3_1.spring_chapter3_1.models.Comment;
import com.chapter3_1.spring_chapter3_1.models.CommentRepository;
import com.chapter3_1.spring_chapter3_1.models.CommentreplaceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentreplaceDTO commentreplaceDTO){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(commentreplaceDTO);
        return comment.getId();
    }
}
