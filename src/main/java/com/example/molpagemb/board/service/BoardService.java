package com.example.molpagemb.board.service;

import java.util.List;

import com.example.molpagemb.board.dto.BoardDTO;

public interface BoardService {
	List<BoardDTO> findAllBoards();
	BoardDTO findBoardByBoardId(Long boardId);
}
