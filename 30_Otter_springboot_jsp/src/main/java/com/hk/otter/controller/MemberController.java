package com.hk.otter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.otter.dtos.UserDto;
import com.hk.otter.service.UserService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	@Autowired
	private UserService userService;
	
	//회원가입 폼 이동
	@GetMapping("/join")
	public String signUp() {
		return "join";
	}
	
	//회원가입
	@PostMapping("/adduser")
	public String addUser(UserDto dto) {
		boolean isS=userService.addUser(dto);
		
		if(isS) {
			System.out.println("회원가입성공");
			return "redirect:/";
		}else {
			System.out.println("회원가입실패");
			return "error";
		}
	}

}
