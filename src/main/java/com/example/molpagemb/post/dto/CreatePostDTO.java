package com.example.molpagemb.post.dto;

import lombok.Data;

@Data
public class CreatePostDTO {
	private Long postId;
	private Long postUserIdNumber;
	private Long postBoardId;
	private String postTitle;
	private String postContent;
	
}
