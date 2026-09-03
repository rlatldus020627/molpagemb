package com.example.molpagemb.post.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.molpagemb.post.dto.CreatePostDTO;
import com.example.molpagemb.post.dto.PostDTO;
import com.example.molpagemb.post.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qwert/posts")
public class PostController {
	private final PostService postService;
	
	@GetMapping("/find-all-posts")
	public ResponseEntity<List<PostDTO>> findAllPosts(){
		return  ResponseEntity.ok(postService.findAllPosts());
		
	}
	
	@GetMapping("/find-all-posts-by-board-id/{postBoardId}")
	public ResponseEntity<List<PostDTO>> findAllPostsByBoardId(@PathVariable("postBoardId") Long boardId){
		return ResponseEntity.ok(postService.findAllPostsByBoardId(boardId));
		
	}

	@GetMapping("/find-all-posts-by-user-id-number/{userIdNumber}")
	public ResponseEntity<List<PostDTO>> findAllPostsByUserIdNumber(@PathVariable("userIdNumber") Long userIdNumber){
		return ResponseEntity.ok(postService.findAllPostsByUserIdNumber(userIdNumber));
	}
	
	@GetMapping("/find-post-by-post-id/{postId}")
	public ResponseEntity<PostDTO> findPostByPostId(@PathVariable("postId") Long postId){
		return ResponseEntity.ok(postService.findPostByPostId(postId));
	}
	
	@PostMapping("/post/{postBoardId}")
	public ResponseEntity<Map<String, Long>> createPost(@PathVariable("postBoardId") Long postBoardId, Authentication authentication, @RequestBody CreatePostDTO createPostDTO){
		Long userId = Long.valueOf(authentication.getName());
		postService.createPost(postBoardId, userId, createPostDTO);
		if (createPostDTO.getPostId() == null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity
				.status(201)
				.body(Map.of("postId", createPostDTO.getPostId()));
		
	}
}
