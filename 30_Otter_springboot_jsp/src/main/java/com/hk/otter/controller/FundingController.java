package com.hk.otter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//펀딩 상품 결제
  	@PostMapping(value = "/payment")
//  	@GetMapping(value = "/payment/{seq}")
  	public String productDetail(@RequestBody RewardDto data, HttpSession session) {
//  		System.out.println("선택한 리워드 번호: " + data.getSeq());
//  	    System.out.println("선택한 리워드 이름: " + data.getReward_name());
//  	    System.out.println("선택한 리워드 가격: " + data.getPrice());
//  	    System.out.println("수량: " + data.getStock());
//  	    System.out.println("총 금액: " + data.getTotal_price());  // total_price 값 확인


  	    // 데이터 세션에 저장
//  	    session.setAttribute("fdto", data);
  	    
  		return "payment";

  	}
}
