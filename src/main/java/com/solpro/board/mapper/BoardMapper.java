package com.solpro.board.mapper;

import com.solpro.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> getLists(); //전체리스트

}