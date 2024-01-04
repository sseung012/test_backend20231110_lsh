package com.hk.otter.config;

import org.springframework.web.servlet.AsyncHandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginInterceptor implements AsyncHandlerInterceptor {
	
@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
	
			System.out.println("LoginInterceptor 실행");
			HttpSession session = request.getSession();
			if(session.getAttribute("ldto") == null) {
				System.out.println("로그인 상태가 아닙니다!");
				response.sendRedirect("/user/signin");
				
				return false; // false를 작성해야 컨트롤러로 진입을 막을 수 있음
			}
		
			else {
				return true; // true이면 컨트롤러로 진입함
			}
	}	
	

}
