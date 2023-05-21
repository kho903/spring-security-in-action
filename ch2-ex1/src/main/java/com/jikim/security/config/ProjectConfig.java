package com.jikim.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		var userDetailsService = new InMemoryUserDetailsManager();
		var user = User.withUsername("user")
			.password("12345")
			.authorities("read")
			.build(); // 주어진 사용자 이름, 암호, 권한 목록으로 사용자 생성
		userDetailsService.createUser(user); // UserDetailsService 에서 관리하도록 사용자 추가

		return userDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // PasswordEncoder 를 컨텍스트에 추가하기 위해 @Bean 어노테이션이 지정된 새 메서드
	}
}
