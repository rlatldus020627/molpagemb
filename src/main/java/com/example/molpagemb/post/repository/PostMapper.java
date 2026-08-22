package com.example.molpagemb.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.molpagemb.post.dto.CreatePostDTO;
import com.example.molpagemb.post.dto.PostDTO;


@Mapper
public interface PostMapper {
	List<PostDTO> findAllPosts(); //모든 글 조회
	List<PostDTO> findAllPostsByBoardId(); //선택한 게시판의 모든 글 조회
	List<PostDTO> findAllPostsByUserIdNumber(); //선택한 유저의 모든 글 조회
	
	PostDTO findPostByPostId(); //선택한 게시글ID의 게시글 하나 조회
	
	void createPost(CreatePostDTO createPostDTO); //게시글 작성
	
	
}
