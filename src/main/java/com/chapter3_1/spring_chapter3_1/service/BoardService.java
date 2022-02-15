package com.chapter3_1.spring_chapter3_1.service;


import com.chapter3_1.spring_chapter3_1.models.Board;
import com.chapter3_1.spring_chapter3_1.models.BoardRepository;
import com.chapter3_1.spring_chapter3_1.models.BoardRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDTO requestDTO){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDTO);
        return board.getId();

    }
}
