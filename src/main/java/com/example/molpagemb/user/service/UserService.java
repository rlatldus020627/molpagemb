package com.example.molpagemb.user.service;

import java.util.List;
import java.util.Optional;

import com.example.molpagemb.user.dto.CreateUserDTO;
import com.example.molpagemb.user.dto.SignInUserDTO;
import com.example.molpagemb.user.dto.UserDTO;

public interface UserService {
	List<UserDTO> findAllUsers();
	List<UserDTO> findAllUsersByUserRole();
	UserDTO findUserByUserId(String userId);
	UserDTO findUserByUserIdNumber(Long userIdNumber);
	
	String createToken(SignInUserDTO signInUserDTO);
	
	void createUser(CreateUserDTO createUserDTO);
	
	Optional<UserDTO> getLoggedUserId(); //로그인한 사용자 조회
	
	boolean existsByUserId(String userId);

}
