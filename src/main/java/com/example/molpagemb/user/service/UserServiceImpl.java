package com.example.molpagemb.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.molpagemb.config.exception.AlreadyExistedUserException;
import com.example.molpagemb.config.jwt.JwtTokenProvider;
import com.example.molpagemb.config.property.ErrorMessagePropertySource;
import com.example.molpagemb.helper.SecurityHelper;
import com.example.molpagemb.user.dto.CreateUserDTO;
import com.example.molpagemb.user.dto.SignInUserDTO;
import com.example.molpagemb.user.dto.UserDTO;
import com.example.molpagemb.user.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final CreateUserDTO createUserDTO;
	private final UserDTO userDTO;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserMapper userMapper;
	private final ErrorMessagePropertySource errorMessagePropertySource;
	
	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Override
	public List<UserDTO> findAllUsers() {
		return userMapper.findAllUsers();
	}

	@Override
	public List<UserDTO> findAllUsersByUserRole() {
		return userMapper.findAllUsersByUserRole();
	}

	@Override
	public UserDTO findUserByUserId(String userId) {
		return userMapper.findUserByUserId(userId);
	}
	
	@Override
	public UserDTO findUserByUserIdNumber(Long userIdNumber) {
		return userMapper.findUserByUserIdNumber(userIdNumber);
	}

	@Override
	public String createToken(SignInUserDTO signInUserDTO) {
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken(signInUserDTO.getUserId(),signInUserDTO.getUserPassword());
			
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
			return jwtTokenProvider.createToken(authentication);
					
		}catch(Exception ex) {
			throw new BadCredentialsException(errorMessagePropertySource.getBadBadCredentials());
			
		}
		
	}
	
	@Override
	public void createUser(CreateUserDTO createUserDTO) {
		UserDTO user = userMapper.findUserByUserId(createUserDTO.getUserId());
		if(user != null) {
			throw new AlreadyExistedUserException(errorMessagePropertySource.getAlreadyExistedUser());
		}
//			createUserDTO.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
		//TODO:패스워드인코더
		userMapper.createUser(createUserDTO);
		
	}

	@Override
	public Optional<UserDTO> getLoggedUserId() {
		Optional<String> loggedUserId = SecurityHelper.getLoggedUserId();
		
		return loggedUserId.map(userMapper::findUserByUserId);
	}

	@Override
	public boolean existsByUserId(String userId) {
		return userMapper.existsByUserId(userId) > 0;
	}
	
	//TODO 로그아웃
	
	




}
