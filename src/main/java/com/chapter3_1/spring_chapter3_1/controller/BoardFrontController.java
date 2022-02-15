package com.chapter3_1.spring_chapter3_1.controller;


import com.chapter3_1.spring_chapter3_1.models.Board;
import com.chapter3_1.spring_chapter3_1.models.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 맴버 변수를 자동 생성
@Controller //JSON으로 데이터 주고 받음 선언
//@RequestMapping("/main/pages")

public class BoardFrontController {
    private final BoardRepository boardRepository;

    //게시글 전체 조회
    @GetMapping("")
    public String getBoard(Model model){
        List<Board> dd = boardRepository.findAllByOrderByModifiedAtDesc();
        model.addAttribute("boards",dd);
        return "index";
    }

    //게시글 전체 조회
    @GetMapping("/board")
    public String detailboard(@RequestParam String id, Model model){
        Long changeid = Long.valueOf(id);
        Board board = boardRepository.findById(changeid).orElseThrow(()->
                new NullPointerException("=========article error==========="));

        model.addAttribute("board",board);
        return "DetailScreen.html";
    }
}
