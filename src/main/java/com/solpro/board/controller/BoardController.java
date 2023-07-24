package com.solpro.board.controller;

import com.solpro.board.entity.Board;
import com.solpro.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    private final BoardMapper mapper;

    @Autowired
    public BoardController(BoardMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/boardList")
    public String boardList(Model model) {

        Board vo = new Board();
        vo.setIdx(1);
        vo.setTitle("제목");
        vo.setContent("내용");
        vo.setWriter("박형준");
        vo.setIndate("2023-07-24");
        vo.setCount(0);

        List<Board> list = new ArrayList<>();
        list.add(vo);

        model.addAttribute("list", list);

        return "board";
    }
}
