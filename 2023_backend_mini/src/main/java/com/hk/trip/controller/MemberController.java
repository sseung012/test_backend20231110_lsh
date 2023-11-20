package com.hk.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.trip.command.LoginCommand;
import com.hk.trip.service.MemberService;

import org.springframework.ui.Model;

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
		
}
