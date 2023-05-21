package com.jikim.security.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jikim.security.model.User;
import com.jikim.security.service.InMemoryUserDetailsService;

@Configuration
public class ProjectConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = new User("user", "12345", "read");
		List<UserDetails> users = List.of(user);
		return new InMemoryUserDetailsService(users);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
