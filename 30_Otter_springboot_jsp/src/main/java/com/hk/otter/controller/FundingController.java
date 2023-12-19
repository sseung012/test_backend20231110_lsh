package com.hk.otter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class FundingController {

	@Autowired
//	private FundingFeign fundingFeign;
	
	@GetMapping("/join")
	public String main() {
		return "join";
	}
	
}
