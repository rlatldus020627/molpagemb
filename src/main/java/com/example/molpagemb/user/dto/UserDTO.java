package com.example.molpagemb.user.dto;

import java.time.LocalDateTime;

import com.example.molpagemb.common.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDTO {
	private Long userIdNumber;
	private String userId;
	private UserRole userRole;
	
	@JsonIgnore
	private String userPassword;
	
	private LocalDateTime userCreatedAt;
	
	
}
