package com.example.molpagemb.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.molpagemb.post.dto.CreatePostDTO;
import com.example.molpagemb.post.dto.PostDTO;
import com.example.molpagemb.post.dto.UpdatePostDTO;
import com.example.molpagemb.post.repository.PostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
	private final PostMapper postMapper;
	private final PostDTO postDTO;
	private final CreatePostDTO createPostDTO;
	private final UpdatePostDTO updatePostDTO;
	
	@Override
	public List<PostDTO> findAllPosts() {
		return postMapper.findAllPosts();
	}

	@Override
	public List<PostDTO> findAllPostsByBoardId() {
		return postMapper.findAllPostsByBoardId();
	}

	@Override
	public List<PostDTO> findAllPostsByUserIdNumber() {
		return postMapper.findAllPostsByUserIdNumber();
	}

	@Override
	public PostDTO findPostByPostId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPost(CreatePostDTO createPostDTO) {
		// TODO Auto-generated method stub
		
	}

}
