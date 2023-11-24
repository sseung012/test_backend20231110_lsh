package com.hk.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.trip.command.AddUserCommand;
import com.hk.trip.command.DelBoardCommand;
import com.hk.trip.command.LoginCommand;
import com.hk.trip.command.UpdateBoardCommand;
import com.hk.trip.command.UserInfoCommand;
import com.hk.trip.dtos.BoardDto;
import com.hk.trip.dtos.MemberDto;
import com.hk.trip.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping(value = "/user")
public class MemberController {

   @Autowired
   private MemberService memberService;
   
   //쿠키
   public Cookie getCookie(String cookieName, HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		Cookie cookie=null;
		if(cookies!=null) {
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals(cookieName)) {
					cookie=cookies[i];
				}
			}
		}
		return cookie;
	}
   
   @GetMapping(value = "/addUser")
   public String addUserForm(Model model) {
      System.out.println("회원가입폼 이동");
      
      //회원가입폼에서 addUserCommand객체를 사용하는 코드가 작성되어 있어서 
      //null일경우 오류가 발생하기때문에 보내줘야 함
      model.addAttribute("addUserCommand", new AddUserCommand());
      
      return "member/addUserForm";
   }
   
   @PostMapping(value = "/addUser")
   public String addUser(@Validated AddUserCommand addUserCommand
                      ,BindingResult result,Model model) {
      System.out.println("회원가입하기");
      
      if(result.hasErrors()) {
         System.out.println("회원가입 유효값 오류");
         return "member/addUserForm";
      }
      
      try {
         memberService.addUser(addUserCommand);
         System.out.println("회원가입 성공");
         return "redirect:/";
      } catch (Exception e) {
         System.out.println("회원가입실패");
         e.printStackTrace();
         return "redirect:addUser";
      }

   }
   
   @ResponseBody
   @GetMapping(value = "/idChk")
   public Map<String,String> idChk(String id){
      System.out.println("ID중복체크");
      
      String resultId=memberService.idChk(id);
      // json객체로 보내기 위해 Map에 담아서 응답
      // text라면 그냥 String으로 보내도 됨
      Map<String,String>map=new HashMap<>();
      map.put("id", resultId);
      return map;
   }
   
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
      
      String path=memberService.login(loginCommand, request, model);
      
      return path;
   }
   
   @GetMapping("/admin_main")
   public String adminMain() {
       // 여기에 필요한 로직 추가
       return "/admin_main";
   }
   
      
   //마이페이지 이동
   @GetMapping(value = "/userinfo")
   public String userinfo(Model model,HttpServletRequest request) {
      System.out.println("내 정보 보기");
      HttpSession session = request.getSession();
      MemberDto mdto=(MemberDto)session.getAttribute("mdto");
      
      // 사용자가 로그인되어 있지 않은 경우 로그인 페이지로 리다이렉트
      if (mdto == null) {
          // 로그인 페이지 경로를 실제 애플리케이션에서 사용하는 경로로 수정하세요.
          return "redirect:/user/login";
      }
      
      String id=mdto.getId();
      //model.addAttribute("addUserCommand", new AddUserCommand());
      MemberDto dto=memberService.Userinfo(id);
      model.addAttribute("dto", dto);
      return "member/userinfo";
   }
   

   @GetMapping(value="/logout")
   public String logout(HttpServletRequest request) {
      System.out.println("로그아웃");
      request.getSession().invalidate();
      return "redirect:/";
   }
   
//   @PostMapping(value="/updateUser")
//   public String updateUser(@Validated UserInfoCommand userInfoCommand
//                     , BindingResult result
//                     ,Model model) {
//      if(result.hasErrors()) {
//         System.out.println("수정내용을 모두 입력하세요");
//         //코드 추가--------------------------------------------
//         MemberDto mdto=memberService.Userinfo(userInfoCommand.getId());
//         model.addAttribute("mdto", mdto);
//         //--------------------------------------------------
//         return "member/userinfo";
//      }
//   
//      memberService.updateUser(userInfoCommand);
//   
//      return "redirect:/member/userinfo?id="
//            + userInfoCommand.getId();
//      
//   }
   
   @PostMapping(value="/updateUser")
   public String updateUser(@Validated UserInfoCommand userInfoCommand
                            , BindingResult result
                            , Model model) {
       if(result.hasErrors()) {
           System.out.println("수정내용을 모두 입력하세요");
           // 코드 추가 --------------------------------------------
           MemberDto mdto = memberService.Userinfo(userInfoCommand.getId());
           model.addAttribute("mdto", mdto);
           // -------------------------------------------------------
           return "member/userinfo";
       }

       memberService.updateUser(userInfoCommand);

       return "redirect:/user/userinfo?id=" + userInfoCommand.getId();
   }

//	public List<MemberDto> getAllUserList();
	@GetMapping(value="/userAllList")
	public String getAllUserList(Model model,HttpServletRequest request) {
		System.out.println("전체회원목록");
		
		List<MemberDto> list=memberService.getAllList();
		model.addAttribute("list", list);
		
		return "member/userAllList";
	}
	

	@GetMapping("/userRoleForm")
	public String updateUserRole(Model model, @RequestParam String id) {
	    MemberDto memberDto = memberService.getMemberById(id);

	    // 조회된 회원 정보를 모델에 추가하여 뷰로 전달
	    model.addAttribute("dto", memberDto);
	    
	    return "member/userRoleForm";
	}
}




