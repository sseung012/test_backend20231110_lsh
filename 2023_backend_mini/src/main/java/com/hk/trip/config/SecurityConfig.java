package com.hk.trip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
//		http.cors().disable().csrf().disable(); //버전업되면서 안씀
		
		//기능 비활성화
		http.cors(AbstractHttpConfigurer::disable)
			.csrf(AbstractHttpConfigurer::disable) // cors, csrf 비활성화
			.formLogin(AbstractHttpConfigurer::disable); //loginform 비활성화
		
		
		return  http.build();
	}
	
	//패스워드 암호화 객체
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
}
