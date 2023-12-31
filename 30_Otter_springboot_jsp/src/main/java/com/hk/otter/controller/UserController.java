package com.hk.otter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hk.otter.dtos.UserDto;
import com.hk.otter.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
	
	//회원가입 폼 이동
	@GetMapping("/join")
	public String signUp() {
		return "join";
	}
	
	//사용자 인증을 완료하면 code들을 반환해준다.
	//반환받은 code를 이용해서 토큰 발급 요청을 진행한다.
	@GetMapping("/authresult")
	public String authResult(String code, Model model) throws IOException, ParseException {
		System.out.println("인증 후 받은 code:" +code);
		
		HttpURLConnection conn=null; //api에서 제공하는 데이터를 받기 위한 연결 객체
		JSONObject result=null; //받아온 데이터를 json으로 저장할 객체
		 
		//인증받고 얻은 code를 통해 토큰을 요청하여 발급받는다.
		URL url=new URL("https://testapi.openbanking.or.kr/oauth/2.0/token?"
						+"code="+code
						+"&client_id=4987e938-f84b-4e23-b0a2-3b15b00f4ffd"
						+"&client_secret=3ff7570f-fdfb-4f9e-8f5a-7b549bf2adec"
						+"&redirect_uri=http://localhost:8087/user/authresult"
						+"&grant_type=authorization_code"
						);
		
		conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST"); //post로 요청
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoOutput(true); //데이터를 가져온다면 true로 설정한다.
		
		//데이터를 실제로 가져오는 작업
		BufferedReader br=new BufferedReader(
							new InputStreamReader(conn.getInputStream(),"utf-8"));
		
		StringBuilder response=new StringBuilder(); //데이터를 저장할 객체
		String responseLine=null;
		while((responseLine=br.readLine())!=null) {
//				System.out.println(responseLine);
			response.append(responseLine.trim()); //데이터를 문자열에 추가
		}
		
		// json 형태의 텍스트 데이터를 json객체로 변환하는 작업
		result=(JSONObject)new JSONParser().parse(response.toString());
		
		// json객체에서 전달받은 값을 가져오기
		String access_token=result.get("access_token").toString();
		String refresh_token=result.get("refresh_token").toString();
		String user_seq_no=result.get("user_seq_no").toString();
		
		System.out.println("access_token:"+access_token);
		System.out.println("refresh_token:"+refresh_token);
		System.out.println("user_seq_no:"+user_seq_no);
		
		//클라이언트로 전달하기 위한 model 저장
		model.addAttribute("access_token", access_token);
		model.addAttribute("refresh_token", refresh_token);
		model.addAttribute("user_seq_no", user_seq_no);
		
		return "authresult";
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
	
	//아이디중복체크 
	@ResponseBody
	@GetMapping(value = "/idChk")
	public Map<String,String> idChk(String id){
		System.out.println("ID중복체크");
		
		String resultId=userService.idChk(id);
		// json객체로 보내기 위해 Map에 담아서 응답
		// text라면 그냥 String으로 보내도 됨
		Map<String,String>map=new HashMap<>();
		map.put("id", resultId);
		return map;
	}

	//로그인 폼 이동하기
	@GetMapping("/signin")
	public String signinForm() {
		System.out.println("로그인폼 이동");
		return "signin";
	}
	
	//로그인하기
	@PostMapping("/login")
	public String login(UserDto dto, HttpServletRequest request, Model model) {
	    UserDto ldto = userService.loginUser(dto);
	    if (ldto == null || !ldto.getUserpassword().equals(dto.getUserpassword())) {
	        System.out.println("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
	        model.addAttribute("loginResult","실패");
	        return "signin";
	    } else {
	        System.out.println("로그인 성공");
	        HttpSession session = request.getSession();
	        session.setAttribute("ldto", ldto);
	        session.setMaxInactiveInterval(60 * 10);
	        System.out.println("로그인한 사용자: " + ldto);
	        model.addAttribute("loginResult","Y");
	        return "redirect:/";
	    }

	}
	
	//로그아웃하기
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("로그아웃");
		HttpSession session=request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}

	@GetMapping("/myinfo")
	public String myinfo(UserDto dto, Model model, HttpServletRequest request) {
		System.out.println("내 정보 보기");
		HttpSession session = request.getSession();
		UserDto ldto = (UserDto)session.getAttribute("ldto");
		request.setAttribute("dto", ldto);
		
		// 사용자가 로그인되어 있지 않은 경우 로그인 페이지로 리다이렉트
		if (ldto == null) {
			return "redirect:/user/signin";
		}
		
		String id=ldto.getId();

		dto=userService.UserInfo(id);
		model.addAttribute("dto", dto);
		return "myinfo";
	}
	

	//마이페이지에서 정보수정
//	@PostMapping(value = "/updateUser")
//	public String updateUser(@Validated UserDto dto, BindingResult result, Model model) {
//	    if (result.hasErrors()) {
//	        System.out.println("수정내용을 모두 입력하세요");
//	        UserDto mdto = userService.UserInfo(dto.getId());
//	        model.addAttribute("mdto", mdto);
//	        return "redirect:/user/myinfo?id=" + dto.getId();
//	    }
//
//	    // UserService를 통해 seq 값을 가져와서 dto에 설정
//	    UserDto userInfo = userService.UserInfo(dto.getId());
//	    dto.setSeq(userInfo.getSeq());
//
//	    userService.updateUser(dto);
//	    System.out.println(dto);
//
//	    // id를 쿼리 스트링으로 추가하여 리다이렉트
//	    return "redirect:/user/myinfo?id=" + dto.getId();
//	}
	
	//나의 정보 수정
	@PostMapping(value = "/updateUser")
	public String updateUser(@Validated UserDto dto, HttpServletRequest request, HttpServletResponse response, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        System.out.println("수정내용을 모두 입력하세요");
	        return "redirect:/user/myinfo?id=" + request.getParameter("id");
	    }

	    String id = request.getParameter("id");
	    String phone = request.getParameter("phone");
	    String useremail = request.getParameter("useremail");

	    boolean isS = userService.updateUser(new UserDto(id, phone, useremail));
	    
	    // Check if the update was successful
	    if (isS) {
	        return "redirect:/user/myinfo?id=" + id; // Use the correct id for redirection
	    } else {
	        System.out.println("수정 실패 메시지 또는 다른 처리를 추가하세요");
	        return "redirect:/user/myinfo?id=" + id; // Use the correct id for redirection
	    }
	}
	
	// 탈퇴하기
	@GetMapping(value = "/delUser")
	public String delUser(UserDto dto, Model model, HttpServletRequest request) {
//	    UserDto ldto = userService.loginUser(dto);
	    
	            // 회원 탈퇴 성공한 경우, delflag 값을 업데이트

	            HttpSession session = request.getSession();
	            UserDto ldto=(UserDto)session.getAttribute("ldto");
	            boolean delUser = userService.delUser(ldto.getId());
	          
	            session.invalidate();
	            System.out.println("탈퇴");
	            return "redirect:/";

	    }	    

	//회원목록
	@GetMapping(value="/manage")
	public String getUserList(Model model, HttpServletRequest request) {
		System.out.println("전체회원목록");

	    List<UserDto> list = userService.getUserList();
	    model.addAttribute("list", list);

	    return "userList"; // 혹은 "user/userAllList"
	}

	
	
	
	
}















