package com.hk.trip.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //환경설정에 관련된걸 처리
public class WebMvcConfig implements WebMvcConfigurer {
	
	//구현된 interceptor 객체를 등록한다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.order(1) //우선순위 설정
				.addPathPatterns("/**") //전체요청에 대해 적용
				.excludePathPatterns("/error","/board/**","/","/user/**","/css/**","/js/**");
	}
}
