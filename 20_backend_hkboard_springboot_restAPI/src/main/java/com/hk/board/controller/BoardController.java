package com.hk.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkService;

@RestController
@RequestMapping("/api/board")
@CrossOrigin(origins = "http://localhost:8086")
public class BoardController {
	
	@Autowired
	public HkService boardService;
	
	//글목록 요청
//	@ResponseBady : @RestController를 정의하면 작성 X
	@CrossOrigin(origins = "http://localhost:8086")
	@GetMapping("/boardlist")
	public Map<String, List<HkDto>> boardList(){
		
		//글 목록 데이터 list 객체를 Map에 저장한다. --> json{"list":list}
		//--> json: {"list":[dto,dto,dto...]} 서버쪽에서 전달할때 형태
		//--> JS  : data["list"] -->>[dto,dto,dto...] 화면쪽에서 받을 형태
		System.out.println("글목록 요청");
		Map<String, List<HkDto>>map=new HashMap<>();
		map.put("list", boardService.getAllList());
		return map;
	}
	//글 추가하기: 전달파라미터 id,title,content
	@PostMapping("/insert")
	public Map<String,Integer>insert(HkDto dto){
		System.out.println("글 추가하기");
		Map<String, Integer>map=new HashMap<>();
		map.put("count", boardService.insertBoard(dto));
		return map;
	}
	
	//글 상세보기: 전달파라미터 seq(글번호)
	@GetMapping("/detail/{seq}")
	public Map<String,HkDto>detail(@PathVariable int seq){
		System.out.println("글 상세조회");
		Map<String, HkDto>map=new HashMap<>();
		map.put("dto", boardService.getBoard(seq));
		return map;
	}
		
	//글 수정하기: 전달파라미터 seq(글번호)
	@GetMapping("/updateform/{seq}")
	public Map<String,HkDto>updateForm(@PathVariable int seq){
		System.out.println("글 수정하기 폼으로 이동");
		Map<String, HkDto>map=new HashMap<>();
		map.put("dto", boardService.getBoard(seq));
		return map;
	}
	//글 수정하기: 전달파라미터 seq(글번호)
	@PutMapping("/update")
	public Map<String,Integer>update(HkDto dto){
		System.out.println("글 수정하기");
		Map<String, Integer>map=new HashMap<>();
		map.put("count", boardService.updateBoard(dto));
		return map;
	}
	//글 삭제하기: 전달파라미터 seq(글번호)
	@DeleteMapping("/delete/{seq}")
	public Map<String,Integer>delete(@PathVariable int seq){
		System.out.println("글 삭제하기");
		Map<String, Integer>map=new HashMap<>();
		map.put("count", boardService.deleteBoard(seq));
		return map;
	}
	//글 여러개 삭제하기: 전달파라미터 seq(글번호)
	@DeleteMapping("/muldel")
	public Map<String,Integer>mulDel(@RequestParam String[]chk){
		System.out.println("글 여러개 삭제하기");
		Map<String, Integer>map=new HashMap<>();
		map.put("count", boardService.mulDel(chk));
		return map;
	}
	
}










