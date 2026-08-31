package com.example.molpagemb.user.service;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.molpagemb.common.enums.UserRole;
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
	private final JwtTokenProvider jwtTokenProvider;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	private final ErrorMessagePropertySource errorMessagePropertySource;
	private final UserDTO userDTO;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Override
	public List<UserDTO> findAllUsers() {
		return userMapper.findAllUsers();
	}

	@Override
	public List<UserDTO> findAllUsersByUserRole(UserRole userRole) {
		return userMapper.findAllUsersByUserRole(userRole);
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
					new UsernamePasswordAuthenticationToken(userDTO.getUserId(), userDTO.getUserPassword());
			
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
			return jwtTokenProvider.createToken(authentication);
					
		}catch(AuthenticationException ex) {
			throw new BadCredentialsException(errorMessagePropertySource.getBadBadCredentials());
			
		}
		
	}
	
	@Override
	public void createUser(CreateUserDTO createUserDTO) {
		UserDTO user = userMapper.findUserByUserId(createUserDTO.getUserId());
		if(user != null) {
			throw new AlreadyExistedUserException(errorMessagePropertySource.getAlreadyExistedUser());
		}
		createUserDTO.setUserPassword(passwordEncoder.encode(createUserDTO.getUserPassword()));
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
