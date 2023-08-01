package com.solpro.board.controller;

import com.solpro.board.entity.Board;
import com.solpro.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        List<Board> list = mapper.getLists();
//        Board vo = new Board();
//        vo.setIdx(1);
//        vo.setTitle("제목");
//        vo.setContent("내용");
//        vo.setWriter("박형준");
//        vo.setIndate("2023-07-24");
//        vo.setCount(0);
//        List<Board> list = new ArrayList<>();
//        list.add(vo);

        model.addAttribute("list", list);
        return "board/board";
    }

    @GetMapping("/boardForm")
    public String boardForm() {

        return "board/boardForm";
    }

    @PostMapping("/boardInsert")
    public String boardInsert(Board vo) {

        mapper.boardInsert(vo);
        return "redirect:/board/boardList";
    }

    @GetMapping("/boardContent")
    public String boardContent(@RequestParam("idx") int idx, Model model) {

        Board vo = mapper.boardContent(idx);
        model.addAttribute("vo", vo);
        mapper.boardCount(idx);
        return "board/boardContent";
    }

    @GetMapping("/boardDelete")
    public String boardDelete(@RequestParam("idx") int idx) {

        mapper.boardDelete(idx);
        return "redirect:/board/boardList";
    }

    @GetMapping("/boardUpdate")
    public String boardUpdateForm(@RequestParam("idx") int idx, Model model) {

        Board vo = mapper.boardContent(idx);
        model.addAttribute("vo", vo);
        return "board/boardUpdate";
    }

    @PostMapping("/boardUpdate")
    public String boardUpdate(Board vo) {

        mapper.boardUpdate(vo);
        return "redirect:/board/boardList";
    }
}
