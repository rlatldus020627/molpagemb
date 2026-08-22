package com.example.molpagemb.config.exception;

public class AlreadyExistedUserException extends RuntimeException{
	public AlreadyExistedUserException(String message) {
		super(message);
	}

}
