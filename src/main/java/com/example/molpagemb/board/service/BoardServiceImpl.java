package com.example.molpagemb.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.molpagemb.board.dto.BoardDTO;
import com.example.molpagemb.board.repository.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper boardMapper;

	@Override
	public List<BoardDTO> findAllBoards() {
		return boardMapper.findAllBoards();
	}

	@Override
	public BoardDTO findBoardByBoardId(Long boardId) {
		return boardMapper.findBoardByBoardId(boardId);
	}

}
