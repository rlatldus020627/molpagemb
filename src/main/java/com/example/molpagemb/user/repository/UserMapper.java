package com.example.molpagemb.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.molpagemb.user.dto.CreateUserDTO;
import com.example.molpagemb.user.dto.UserDTO;

@Mapper
public interface UserMapper {
	List<UserDTO> findAllUsers(); //모든 유저 조회
	List<UserDTO> findAllUsersByUserRole(); //선택한 userRole에 해당하는 모든 유저 조회
	UserDTO findUserByUserId(String userId); //userId로 유저 한 명 조회
	UserDTO findUserByUserIdNumber(Long userIdNumber); //userIdNumber로 유저 한 명 조회
	
	void createUser(CreateUserDTO createUserDTO); //회원가입(유저생성)
	
	int existsByUserId(String userId);
	
}
