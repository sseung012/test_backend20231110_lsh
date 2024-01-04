package com.hk.otter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.dtos.UserDto;
import com.hk.otter.feignMapper.OpenBankingFeign;
import com.hk.otter.service.UserService;


@Controller
@RequestMapping("/banking")
public class FundingController {
	
	@Autowired
	private OpenBankingFeign openBankingFeign;
	
	@Autowired
	private UserService userService;
	
	//펀딩 상품 결제

  	@PostMapping(value = "/payment")
  	public String productDetail(String[] count) {

//  		System.out.println("펀딩상품보기");
//  		UserDto ldto = userService.(seq);
  		
//  		List<RewardDto> rlist = (List<RewardDto>) userService.rewardOption(seq);
//		model.addAttribute("rlist", rlist);
 		
//  		model.addAttribute("dto",ldto);
  		return "payment";

  	}
}
