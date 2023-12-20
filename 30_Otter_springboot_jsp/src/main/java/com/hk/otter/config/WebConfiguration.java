package com.hk.otter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hk.otter.config.LoginInterceptor;


@Configuration
public class WebConfiguration implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 추가할 인터셉터 정의
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/banking/*");
	}

}
