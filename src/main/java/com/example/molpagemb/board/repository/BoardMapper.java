package com.example.molpagemb.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.molpagemb.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	List<BoardDTO> findAllBoards();
	BoardDTO findBoardByBoardId(Long boardId);
	

}
