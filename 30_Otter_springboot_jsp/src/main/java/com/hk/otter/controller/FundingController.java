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
import com.hk.otter.service.PaymentService;
import com.hk.otter.service.UserService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/banking")
public class FundingController {
	
	@Autowired 
	private OpenBankingFeign openBankingFeign;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentService paymentService;
	
	//결제
	@PostMapping(value = "/payment")
  	public String productDetail(String[] count, Integer seq, Model model) {
		System.out.println("결제");
//  		RewardDto rdto = paymentService.rewardOption(int seq);
		RewardDto dto = (RewardDto)paymentService.rewardOption(seq);
		List<RewardDto> list = (List<RewardDto>) paymentService.rewardOption(seq);
		model.addAttribute("rrlist", list);
		model.addAttribute("dto",dto);
  		return "payment";

  	}
	

}
