package com.hk.otter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class HomeController {

	@GetMapping("index")
	public String index() {
		
		return "index";
	}
}





