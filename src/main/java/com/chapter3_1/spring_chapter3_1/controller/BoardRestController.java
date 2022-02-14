package com.chapter3_1.spring_chapter3_1.controller;


import com.chapter3_1.spring_chapter3_1.models.Board;
import com.chapter3_1.spring_chapter3_1.models.BoardRepository;
import com.chapter3_1.spring_chapter3_1.models.BoardRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 맴버 변수를 자동 생성
@RestController //JSON으로 데이터 주고 받음 선언
public class BoardRestController {
    private final BoardRepository boardRepository;

    //게시글 전체 조회
    @GetMapping("/api/board")
    public List<Board> getBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    //게시글 등록
    @PostMapping("/api/board")
    public Board createBoard(@RequestBody BoardRequestDTO requestDTO){
        Board board = new Board(requestDTO);
        return boardRepository.save(board);
    }


}
