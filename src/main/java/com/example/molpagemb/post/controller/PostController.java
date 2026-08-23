package com.example.molpagemb.post.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.molpagemb.post.dto.PostDTO;
import com.example.molpagemb.post.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qwert/post")
public class PostController {
	private final PostService postService;
	
	@GetMapping("/find-all-posts")
	public ResponseEntity<List<PostDTO>> findAllPosts(){
		return  ResponseEntity.ok(postService.findAllPosts());
		
	}
	
	@GetMapping("/find-all-posts-by-board-id")
	public ResponseEntity<List<PostDTO>> findAllPostsByBoardId(Long boardId){
		return ResponseEntity.ok(postService.findAllPostsByBoardId(boardId));
		
	}

	@GetMapping("/find-all-posts-by-user-id-number")
	public ResponseEntity<List<PostDTO>> findAllPostsByUserIdNumber(Long userIdNumber){
		return ResponseEntity.ok(postService.findAllPostsByUserIdNumber(userIdNumber));
	}
	
	@GetMapping("/find-post-by-post-id")
	public ResponseEntity<PostDTO> findPostByPostId(Long postId){
		return ResponseEntity.ok(postService.findPostByPostId(postId));
	}
}
