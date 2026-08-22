package com.example.molpagemb.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.molpagemb.config.jwt.JwtTokenDTO;
import com.example.molpagemb.helper.CookieHelper;
import com.example.molpagemb.user.dto.CreateUserDTO;
import com.example.molpagemb.user.dto.SignInUserDTO;
import com.example.molpagemb.user.dto.UserDTO;
import com.example.molpagemb.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qwert")
public class UserController {
	private final UserService userService;
	private final CookieHelper cookieHelper;
	
	@PostMapping("/sign-up")
	public ResponseEntity<Void> signUp(@RequestBody CreateUserDTO createUserDTO){
		userService.createUser(createUserDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{id}").buildAndExpand(createUserDTO.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PostMapping("/sign-in")
	public ResponseEntity<JwtTokenDTO> signIn(@RequestBody SignInUserDTO signInUserDTO){
		String token = userService.createToken(signInUserDTO);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("set-cookie", cookieHelper.makeJwtCookie(token));
		return null;
	}
	
	@PostMapping("/sign-out")
	public ResponseEntity<Void> signOut(){
		HttpHeaders httpHeaders = new HttpHeaders();
		cookieHelper.deleteJwtCookie(httpHeaders);
		return ResponseEntity.ok().headers(httpHeaders).body(null);
	}
	
	@GetMapping("/find-all-users")
	public ResponseEntity<List<UserDTO>> findAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}
	
	@GetMapping("/find-all-users-by-user-role")
	public ResponseEntity<List<UserDTO>> findAllUsersByUserRole(){
		return ResponseEntity.ok(userService.findAllUsersByUserRole());
	}
	
	@GetMapping("/find-user-by-user-id-number")
	public ResponseEntity<UserDTO> findUserByUserIdNumber(Long UserId){
		return ResponseEntity.ok(userService.findUserByUserIdNumber(UserId));
	}
	
	@GetMapping("/find-user-by-user-id")
	public ResponseEntity<UserDTO> findUserByUserId(String userId){
		return ResponseEntity.ok(userService.findUserByUserId(userId));
	}
}
