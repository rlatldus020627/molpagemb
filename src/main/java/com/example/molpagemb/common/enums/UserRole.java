package com.example.molpagemb.common.enums;

public enum UserRole {
	ADMIN("관리자"),
	USER("일반유저"),
	SPECIAL("특별유저");
	
	private final String description;
	
	UserRole(String description){
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

}
