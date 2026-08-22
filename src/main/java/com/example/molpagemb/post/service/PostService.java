package com.example.molpagemb.post.service;

import java.util.List;

import com.example.molpagemb.post.dto.CreatePostDTO;
import com.example.molpagemb.post.dto.PostDTO;

public interface PostService {
	List<PostDTO> findAllPosts();
	List<PostDTO> findAllPostsByBoardId();
	List<PostDTO> findAllPostsByUserIdNumber();
	PostDTO findPostByPostId();
	void createPost(CreatePostDTO createPostDTO);

}
