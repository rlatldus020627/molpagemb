package com.example.molpagemb.config.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.molpagemb.user.dto.UserDTO;
import com.example.molpagemb.user.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService{
	private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDTO user = userMapper.findUserByUserId(userId);
		
		List<SimpleGrantedAuthority> grantedAuthorities = user.getUserRole().stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).toList();
		return new User(user.getUserId(), user.getUserPassword(), grantedAuthorities);
	
	}
}
