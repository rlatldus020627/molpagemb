package com.example.molpagemb.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDTO {
	private Long boardId;
	private String boardName;
	private LocalDateTime boardCreatedAt;
}
