package com.hk.otter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.otter.dtos.ProductDto;
import com.hk.otter.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@ResponseBody
@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
//	//인덱스-프로젝트 작게 조회
//  	@GetMapping(value="/index")
//  	public String getProductMini(Model model, HttpServletRequest request) {
//  		System.out.println("프로젝트목록");
//
//  	    List<ProductDto> list = productService.getProductMini();
//  	    model.addAttribute("list", list);
//
//  	    return "productList"; 
//  	}
}





