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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.trip.command.DelBoardCommand;
import com.hk.trip.command.InsertBoardCommand;
import com.hk.trip.command.ReplyBoardCommand;
import com.hk.trip.command.UpdateBoardCommand;
import com.hk.trip.dtos.BoardDto;
import com.hk.trip.service.BoardService;
import com.hk.trip.utils.Paging;
import com.hk.trip.utils.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/board")
//@SessionAttributes("pnum") // 세션에 "pnum" 속성을 저장
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/boardList")
    public String boardList(@RequestParam(name = "pnum", required = false) String pnum,
                            Model model) {
        System.out.println("글목록 보기");
        System.out.println("페이지번호:"+pnum);
        List<BoardDto> list = boardService.getAllList(pnum);
        System.out.println("list:"+list.size());
        model.addAttribute("list", list);
        model.addAttribute("delBoardCommand", new DelBoardCommand());

        int pcount = boardService.getPCount();
        model.addAttribute("pcount", pcount);

        // ----페이지 번호 유지를 위한 코드-------------
        // 페이지 번호를 전달하지 않으면 세션에 저장된 페이지 번호를 사용
        if (pnum == null) {
            pnum = (String) model.asMap().get("pnum"); // 현재 조회 중인 글 페이지 번호
        } else {
            // 새로 페이지를 요청할 경우 세션에 저장
            model.addAttribute("pnum", pnum);
        }
        // ---페이지 번호 유지를 위한 코드 종료------------

        // ---페이지에 페이징 처리 기능 추가
        // 필요한 값: 페이지수, 페이지번호, 페이지범위(페이지수)
        Map<String, Integer> map = Paging.pagingValue(pcount, pnum, 10);
        model.addAttribute("pMap", map);

        return "board/boardList"; // "WEB-INF/views/" + boardList + ".jsp
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
	public String boardDetail(int board_seq, Model model) {
		BoardDto dto=boardService.getBoard(board_seq);
		
		//유효값처리용
		model.addAttribute("updateBoardCommand", new UpdateBoardCommand());
		//출력용
		model.addAttribute("dto", dto);
		System.out.println(dto);
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
//	        model.addAttribute("list", list);
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













