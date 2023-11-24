package com.hk.trip.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hk.trip.command.AddUserCommand;
import com.hk.trip.command.LoginCommand;
import com.hk.trip.command.UserInfoCommand;
import com.hk.trip.dtos.BoardDto;
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
	
//	public List<MemberDto> getUserinfo(){
//		return memberMapper.getUserinfo();
//	}
	
	//회원가입
	public boolean addUser(AddUserCommand addUserCommand) {
		
		MemberDto mdto=new MemberDto();
		mdto.setId(addUserCommand.getId());
		mdto.setName(addUserCommand.getName());
		//password암호화하여 저장하자
		mdto.setPassword(passwordEncoder.encode(addUserCommand.getPassword()));
		mdto.setEmail(addUserCommand.getEmail());
		mdto.setAddress(addUserCommand.getAddress());
		mdto.setRole(RoleStatus.USER+"");//등급추가
		
		return memberMapper.insertUser(mdto);
	}
	
	//ID중복체크
	public String idChk(String id) {
		return memberMapper.idChk(id);
	}
	
	//로그인
	public String login(LoginCommand loginCommand, HttpServletRequest request, Model model) {
		MemberDto dto = memberMapper.getLogin(loginCommand.getId());
		String path = "";
		if(dto!=null) {
			//로그인 폼에서 입력받은 패스워드값과 DB에 암호화된 패스워드 비교
			if(passwordEncoder.matches(loginCommand.getPassword(), dto.getPassword())) {
				System.out.println("패스워드 같음 : 회원이 맞음");
				//session객체에 로그인 정보 저장
				request.getSession().setAttribute("mdto", dto);
				
				if(dto.getRole().toUpperCase().equals("ADMIN")) {
					path="admin_main";
				}else if(dto.getRole().toUpperCase().equals("USER")){
					path="home";
				}
//				return path;
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
//	

	//mypage
	public MemberDto Userinfo(String id) {
	
		return memberMapper.getUserInfo(id);
	}
	
	//나의 정보 수정
	public boolean updateUser(UserInfoCommand userInfoCommand){
		MemberDto mdto=new MemberDto();
		mdto.setId(userInfoCommand.getId());
		mdto.setAddress(userInfoCommand.getAddress());
		mdto.setEmail(userInfoCommand.getEmail());
		
//		return "redirect:/user/userinfo?id=" + userInfoCommand.getId();
		
		return memberMapper.updateUser(mdto);
	}

	//회원정보 조회
	public List<MemberDto> getAllList() {
		return memberMapper.getAllUserList();
	}

	public MemberDto getMemberById(String id) {
	    return memberMapper.getMemberById(id);
	}

	// 회원등급 수정
	public void updateUserRole(String id, String role) {
	    // 실제로는 데이터베이스에서 회원의 등급을 업데이트하거나 다른 작업을 수행할 수 있습니다.
	    memberMapper.updateUserRole(id, role);
	}

}





