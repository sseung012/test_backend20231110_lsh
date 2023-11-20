package com.hk.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hk.trip.command.AddUserCommand;
import com.hk.trip.command.LoginCommand;
import com.hk.trip.dtos.MemberDto;
import com.hk.trip.mapper.MemberMapper;
import com.hk.trip.status.RoleStatus;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor ;lombok 기능 : final 필드를 초기화 - Autowired 생략가능
@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//회원가입
	public boolean addUser(AddUserCommand addUserCommand) {
		
		MemberDto mdto=new MemberDto();
		mdto.setId(addUserCommand.getId());
		mdto.setName(addUserCommand.getName());
		//password암호화하여 저장하자
		mdto.setPassword(passwordEncoder.encode(addUserCommand.getPassword()));
		mdto.setEmail(addUserCommand.getEmail());
		mdto.setAddress(addUserCommand.getAddress());
		
		return memberMapper.insertUser(mdto);
	}
	
	//ID중복체크
	public String idChk(String id) {
		return memberMapper.idChk(id);
	}
	
	//로그인
	public String login(LoginCommand loginCommand, HttpServletRequest request, Model model) {
		MemberDto dto = memberMapper.getLogin(loginCommand.getId());
		String path = "home";
		if(dto!=null) {
			//로그인 폼에서 입력받은 패스워드값과 DB에 암호화된 패스워드 비교
			if(passwordEncoder.matches(loginCommand.getPassword(), dto.getPassword())) {
				System.out.println("패스워드 같음 : 회원이 맞음");
				//session객체에 로그인 정보 저장
				request.getSession().setAttribute("mdto", dto);
				return path;
			}else {
				System.out.println("패스워드 틀림");
				model.addAttribute("msg", "패스워드를 확인하세요");
				path="member/login";
			}
		}else {
			System.out.println("회원이 아닙니다.");
			model.addAttribute("msg", "아이디를 확인하세요");
			path="member/login";
		}
		return path;
	}
	
//	@GetMapping(value = "/logout")
//	public String logout(HttpServletRequest request) {
//		System.out.println("로그아웃");
//		request.getSession().invalidate();
//		return "redirect:/";
//	}
}





