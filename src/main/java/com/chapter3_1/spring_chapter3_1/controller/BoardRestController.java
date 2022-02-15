package com.chapter3_1.spring_chapter3_1.controller;


import com.chapter3_1.spring_chapter3_1.models.Board;
import com.chapter3_1.spring_chapter3_1.models.BoardRepository;
import com.chapter3_1.spring_chapter3_1.models.BoardRequestDTO;
import com.chapter3_1.spring_chapter3_1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final로 선언된 맴버 변수를 자동 생성
@RestController //JSON으로 데이터 주고 받음 선언
public class BoardRestController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    //게시글 등록
    @PostMapping("/api/board")
    public Board createBoard(@RequestBody BoardRequestDTO requestDTO){
        Board board = new Board(requestDTO);
        return boardRepository.save(board);
    }

    //게시글 수정
    @PutMapping("api/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDTO requestDTO){
        boardService.update(id,requestDTO);
        return id;
    }

    //게시글 삭제
    @DeleteMapping("api/board/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }
}
