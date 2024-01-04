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
			
//		System.out.println(Arrays.toString(reward_name)+"\n"
//				          +Arrays.toString(count)+"\n"
//				          +total_price);
	
		model.addAttribute("reward_name", reward_name);
		model.addAttribute("count", count);

		return  "payment" ;
	}


}
