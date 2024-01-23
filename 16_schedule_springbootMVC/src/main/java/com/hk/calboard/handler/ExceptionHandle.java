package com.hk.calboard.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionHandle {
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	
	//실행중에 오류가 발생하면 실행되는 메서드
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		logger.error("Exception발생:{}",e.getMessage());
		model.addAttribute("msg","오류가 발생하여 확인중");
		return "thymeleaf/error";
	}

}
