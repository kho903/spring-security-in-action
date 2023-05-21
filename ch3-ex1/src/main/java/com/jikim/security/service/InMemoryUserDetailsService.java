package com.jikim.security.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InMemoryUserDetailsService implements UserDetailsService {
	private final List<UserDetails> users; // UserDetailsService는 메모리 내 사용자의 목록을 관리함.

	public InMemoryUserDetailsService(List<UserDetails> users) {
		this.users = users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return users.stream()
			.filter(user -> user.getUsername().equals(username)) // 사용자의 목록에서 요청된 사용자 이름과 일치하는 항목을 필터링함.
			.findFirst() // 일치하는 사용자가 있으면 반환함.
			.orElseThrow(() -> new UsernameNotFoundException("User not found")); // 존재하지 않으면 예외 던짐.
	}
}
