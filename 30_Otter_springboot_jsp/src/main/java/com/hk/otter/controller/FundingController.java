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
import org.springframework.web.bind.annotation.RequestParam;

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
	public String productDetail(@RequestParam("total_price") int total_price,
            @RequestParam("reward_name") String reward_name,
            @RequestParam("count") int count,
            @RequestBody RewardDto data,
            HttpSession session) {
		// total_price, reward_name, count를 사용하여 필요한 로직 수행
		System.out.println("total_price: " + total_price);
		System.out.println("reward_name: " + reward_name);
		System.out.println("count: " + count);
		
		// 나머지 데이터는 RewardDto로 매핑됨
		System.out.println("data: " + data);
		
		// 세션에 데이터 저장
		session.setAttribute("fdto", data);
		
		return "payment";
  	}
}
