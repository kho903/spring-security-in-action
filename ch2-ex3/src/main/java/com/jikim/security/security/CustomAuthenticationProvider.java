package com.jikim.security.security;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 인증 논리를 추가할 위치

		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());

		if ("user".equals(username) && "12345".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		} else {
			throw new AuthenticationCredentialsNotFoundException("Error in authentication!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		// Authentication 형식의 구현을 추가할 위치
		return UsernamePasswordAuthenticationToken.class
			.isAssignableFrom(authenticationType);
	}
}
