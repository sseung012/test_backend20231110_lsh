package com.hk.otter.controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.dtos.UserDto;
import com.hk.otter.feignMapper.OpenBankingFeign;
import com.hk.otter.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/banking")
public class FundingController {
	
	@Autowired
	private OpenBankingFeign openBankingFeign;
	
	@Autowired
	private UserService userService;
	

	@PostMapping(value = "/payment")
	public String productDetail( Model model, HttpSession session,String[] reward_name,String[] count,String total_price ) {
			
			System.out.println(Arrays.toString(reward_name)+"\n"
					          +Arrays.toString(count)+"\n"
					          +total_price);
		
			model.addAttribute("reward_name", reward_name);
			model.addAttribute("count", count);
//		try {
//	        // selectedRewards는 JSON 형태의 문자열이므로 이를 파싱하여 사용
//	        List<Map<String, String>> selectedRewardsList = (List<Map<String, String>>) requestData.get("selectedRewards");
//
//	        // productDto 객체에서 title 속성을 가져와서 모델에 추가
//	        ProductDto productDto = (ProductDto) session.getAttribute("productDto");
//	        if (productDto != null && productDto.getTitle() != null) {
//	            model.addAttribute("title", productDto.getTitle());
//	        }
//
//	        // 나머지 로직 수행
//	        model.addAttribute("selectedRewards", selectedRewardsList);
//
//	        // 세션에 데이터 저장
//	        session.setAttribute("selectedRewards", selectedRewardsList);
//
//	        return "payment";
//	    } catch (Exception e) {
//	        // 예외 처리
//	        e.printStackTrace();
//	        return "error";
//	    }
		return  "payment" ;
	}


	
	
	
	//펀딩 상품 결제

//  	@PostMapping(value = "/payment")
//  	public String productDetail(String[] stock_count) {
//
////  		System.out.println("펀딩상품보기");
////  		UserDto ldto = userService.(seq);
//  		
////  		List<RewardDto> rlist = (List<RewardDto>) userService.rewardOption(seq);
////		model.addAttribute("rlist", rlist);
// 		
////  		model.addAttribute("dto",ldto);
//  		return "payment";


//			}
}
