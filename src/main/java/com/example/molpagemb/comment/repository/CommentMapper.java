package com.example.molpagemb.comment.repository;

import java.util.List;

import com.example.molpagemb.comment.dto.CommentDTO;

public interface CommentMapper {
	List<CommentDTO> findAllComments(); //모든 댓글 조회
	List<CommentDTO> findAllCommentsByPostId();//선택한 게시글의 모든 댓글 조회
	List<CommentDTO> findAllCommentsByUserIdNumber();//선택한 유저의 모든 댓글 조회
	CommentDTO findCommentByCommentId();//선택한 하나의 댓글 조회
}
