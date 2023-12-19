package com.hk.otter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.otter.feignMapper.OpenBankingFeign;
import com.hk.otter.service.UserService;

@Controller
@RequestMapping("/banking")
public class FundingController {
	
	@Autowired
	private OpenBankingFeign openBankingFeign;
	
	@Autowired
	private UserService userService;
}
