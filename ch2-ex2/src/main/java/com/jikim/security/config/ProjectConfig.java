package com.jikim.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class ProjectConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		var userDetailsService = new InMemoryUserDetailsManager();

		var user = User.withUsername("user")
			.password("12345")
			.authorities("read")
			.build();
		userDetailsService.createUser(user);

		// 이제 configure() 메서드에서 userDetailsService와 PasswordEncoder가 설정됨.
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(
				NoOpPasswordEncoder.getInstance());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
			.authorizeRequests()
			.anyRequest().authenticated(); // 모든 요청에 인증을 요구하도록 지정.
	}
}
