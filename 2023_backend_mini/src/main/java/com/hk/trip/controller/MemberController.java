package com.hk.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.trip.command.LoginCommand;
import com.hk.trip.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping(value = "/user")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//로그인 폼 이동
	@GetMapping(value = "/login")
	public String loginForm(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return "member/login";
	}
	
	//로그인 실행
	@PostMapping(value = "/login")
	public String login(@Validated LoginCommand loginCommand
			           ,BindingResult result
			           ,Model model
			           ,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("로그인 유효값 오류");
			return "member/login";
		}
		
		String path=memberService.Login(loginCommand, request, model);
		
		return path;
	}
		
}
