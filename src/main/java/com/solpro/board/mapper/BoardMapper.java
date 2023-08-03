package com.solpro.board.mapper;

import com.solpro.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> getLists(); //전체리스트

    public void boardInsert(Board board);

    public Board boardContent(int boardIdx);

    public void boardDelete(int boardIdx);

    public void boardUpdate(Board board);

    public void boardCount(int boardIdx);
}
