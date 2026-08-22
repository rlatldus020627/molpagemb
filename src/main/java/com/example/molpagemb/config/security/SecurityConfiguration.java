package com.example.molpagemb.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.molpagemb.config.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableMethodSecurity
public class SecurityConfiguration {
	private final JwtTokenProvider jwtTokenProvider;

}
