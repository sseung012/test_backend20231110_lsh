package com.hk.trip.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.trip.command.DelBoardCommand;
import com.hk.trip.command.InsertBoardCommand;
import com.hk.trip.command.ReplyBoardCommand;
import com.hk.trip.command.UpdateBoardCommand;
import com.hk.trip.dtos.BoardDto;
import com.hk.trip.dtos.MemberDto;
import com.hk.trip.service.BoardService;
import com.hk.trip.utils.Util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//답글 들여쓰기
//	@Autowired
//	private Util util; // Util 클래스 주입
	
	//getCookie 기능 구현
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
	
	@GetMapping(value = "/boardList")
	public String boardList(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		//글목록으로 이동하면 쿠키 rseq값을 삭제하자
		Cookie cookie=getCookie("rseq", request);
		if(cookie!=null) {
			cookie.setMaxAge(0); //유효기간 0 --> 삭제됨
			response.addCookie(cookie); //클라이언트로 변경사항을 전달
		} //쿠키 삭제 코드 종료-------------
//		
//		//--------페이지번호 유지를 위한 코드
//		//페이지번호를 전달하지 않으면 세션에 저장된 페이지번호를 사용
//		HttpSession session=request.getSession();
//		if(pnum==null) {
//			pnum=(String)session.getAttribute("pnum"); //현재 조회중인 페이지번호
//		}else {
//			//새로 페이지를 요청할 경우 세션에 저장
//			session.setAttribute("pnum", pnum);
//		} //--------페이지번호 유지를 위한 코드 종료-----------
		
		System.out.println("글목록 보기");

		List<BoardDto> list=boardService.getAllList();
		model.addAttribute("list", list);
		model.addAttribute("delBoardCommand", new DelBoardCommand());
		
		
		return "board/boardList";// forward 기능, "redirect:board/boardList"
	}  

	@GetMapping(value = "/boardInsert")
	public String boardInsertForm(Model model) {
		model.addAttribute("insertBoardCommand", new InsertBoardCommand());
		return "board/boardInsertForm";
	}

	@GetMapping("/admin_main")
	   public String adminMain() {
	       // 여기에 필요한 로직 추가
	       return "/admin_main";
	   }
	
	//글 추가하기
	@PostMapping(value = "/boardInsert")
	public String boardInsert(@Validated InsertBoardCommand insertBoardCommand 
			                ,BindingResult result
			                ,MultipartRequest multipartRequest //multipart data를 처리할때 사용
							,HttpServletRequest request
			                ,Model model) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			System.out.println("글을 모두 입력하세요");
			return "board/boardInsertForm";
		}
		
		boardService.insertBoard(insertBoardCommand,multipartRequest
				                ,request);
		
		return "redirect:/board/boardList";
	}
	
	//상세보기
	@GetMapping(value = "/boardDetail")
	public String boardDetail(int board_seq, Model model
					, HttpServletRequest request
					, HttpServletResponse response) {
		//로그인 되어있지 않은경우
		HttpSession session = request.getSession();
	    MemberDto mdto = (MemberDto) session.getAttribute("mdto");

	    // 사용자가 로그인되어 있지 않은 경우
	    if (mdto == null) {
	        // 로그인 페이지로 리다이렉트
	        return "redirect:/user/login";
	    }
		
		BoardDto dto=boardService.getBoard(board_seq);
		
		//유효값처리용
		model.addAttribute("updateBoardCommand", new UpdateBoardCommand());
		//출력용
		model.addAttribute("dto", dto);
		System.out.println(dto);
		
		
		//--------getCookie메서드 구현해서 활용하기
		Cookie cookieObj=getCookie("rseq", request);
		
		String s=null;
		if(cookieObj!=null) {
			s = cookieObj.getValue();				
		}
		
		//"rseq"라는 이름의 값이 있는지 확인(쿠키값이 없는 경우)
		if(s==null || !s.equals(String.valueOf(board_seq))) {
			//쿠키객체 생성하기
			//				cookie에 값을 저장할 때 타입은 String이다.
			Cookie cookie=new Cookie("rseq", String.valueOf(board_seq));
			cookie.setMaxAge(60*10); //유효기간 설정
			response.addCookie(cookie); //클라이언트로 cookie객체 전달
			
			//---조회수 올리기 코드
			boardService.readCount(board_seq);//조회수 증가
			//조회수 코드 종료			
			
		}
		//-------여기까지 쿠키
		
		return "board/boardDetail";
	}
	
	//수정하기
	@PostMapping(value = "/boardUpdate")
	public String boardUpdate(
				@Validated UpdateBoardCommand updateBoardCommand
				,BindingResult result
				,Model model) {
		
		if(result.hasErrors()) {
			System.out.println("수정내용을 모두 입력하세요");
			//코드 추가--------------------------------------------
			BoardDto dto=boardService.getBoard(updateBoardCommand.getBoard_seq());
			model.addAttribute("dto", dto);
			//--------------------------------------------------
			return "board/boardDetail";
		}
		
		boardService.updateBoard(updateBoardCommand);
		
		return "redirect:/board/boardDetail?board_seq="
				+ updateBoardCommand.getBoard_seq();
	}
	
//	@GetMapping(value = "/download")
//	public void download(int file_seq, HttpServletRequest request
//			                         , HttpServletResponse response) throws UnsupportedEncodingException {
//		
//		FileBoardDto fdto=fileService.getFileInfo(file_seq);//파일정보가져오기
//		
//		fileService.fileDownload(fdto.getOrigin_filename()
//				                ,fdto.getStored_filename()
//				                ,request,response);
//	}
//	
	@RequestMapping(value="mulDel",method = {RequestMethod.POST,RequestMethod.GET})
	public String mulDel(@Validated DelBoardCommand delBoardCommand
						 ,BindingResult result
			             , Model model) {
		if(result.hasErrors()) {
			System.out.println("최소하나 체크하기");
			List<BoardDto> list=boardService.getAllList();
			model.addAttribute("list", list);
			return "board/boardlist";
		}
		boardService.mulDel(delBoardCommand.getBoard_seq());   
		System.out.println("글삭제함");
		return "redirect:/board/boardList";
	}
	
	//답글추가
	@RequestMapping(value = "replyBoard", method = {RequestMethod.POST, RequestMethod.GET})
	public String replyBoard(@Validated ReplyBoardCommand replyBoardCommand,BindingResult result
										,HttpServletRequest request
							            ,Model model) {
//		boolean isS=BoardService.replyBoard(dto);
//		
//		if(isS) {
//			return "redirect:boardList.do";
//		}else{
//			model.addAttribute("msg", "답글 추가 실패");
//			return "error";
//		}
//			
		if(result.hasErrors()) {
			System.out.println("글을 모두 입력하세요");
			return "board/boardDetail";
		}
		
		boardService.replyBoard(replyBoardCommand, request);
		
		return "redirect:/board/boardList?board_seq=" + replyBoardCommand.getBoard_seq();
	}
	
}













