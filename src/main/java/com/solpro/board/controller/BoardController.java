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


    @GetMapping("/")
    public String boardList(Model model) {

        List<Board> list = mapper.getLists();

        model.addAttribute("list", list);
        return "board/board";
    }

    @GetMapping("/boardForm")
    public String boardForm() {

        return "board/boardForm";
    }

    @PostMapping("/boardInsert")
    public String boardInsert(Board board) {

        mapper.boardInsert(board);
        return "redirect:/";
    }

    @GetMapping("/boardContent")
    public String boardContent(@RequestParam("boardIdx") int boardIdx, Model model) {

        Board board = mapper.boardContent(boardIdx);
        model.addAttribute("board", board);
        mapper.boardCount(boardIdx);
        return "board/boardContent";
    }

    @GetMapping("/boardDelete")
    public String boardDelete(@RequestParam("boardIdx") int boardIdx) {

        mapper.boardDelete(boardIdx);
        return "redirect:/";
    }

    @GetMapping("/boardUpdate")
    public String boardUpdateForm(@RequestParam("boardIdx") int boardIdx, Model model) {

        Board board = mapper.boardContent(boardIdx);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }

    @PostMapping("/boardUpdate")
    public String boardUpdate(Board board) {

        mapper.boardUpdate(board);
        return "redirect:/";
    }
}