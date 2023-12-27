package com.hk.otter.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
   
	@GetMapping(value = "/insertProductForm")
      public String insertProductForm(Model model, InsertProductCommand insertProductCommand) {
         // logger.info("프로젝트만들기폼이동");
//         System.out.println(insertProductCommand);
         
         // addCalBoardfForm 페이지에서 유효값 처리를 위해 
         // insertCalCommand 받고 있기 때문에 보내줘야 해!
         model.addAttribute("insertProductCommand", insertProductCommand);
         return "addProductForm";
      }
      
      /*
      @PostMapping(value = "/insertProduct")
      public String insertProduct(@Validated InsertProductCommand insertProductCommand,
                          BindingResult result
                          , MultipartRequest multipartRequest
              			  , Model model, HttpServletRequest request)throws Exception { 

         // 파라미터 순서 꼭 맞춰줄 것!
//          logger.info("일정추가하기");
         System.out.println(insertProductCommand);
         
         if(result.hasErrors()) { // 에러가 있으면 돌려보냄
            System.out.println("프로젝트 만들기 유효값 오류");
            return "addProductForm";
         }
       */  
	@PostMapping(value = "/insertProduct")
    public String insertProduct(InsertProductCommand insertProductCommand,
                         MultipartRequest multipartRequest
            			  , Model model, HttpServletRequest request)throws Exception { 
		System.out.println(insertProductCommand);
         try {
			productService.insertProduct(insertProductCommand, multipartRequest, request);
			System.out.println("프로젝트 만들기 성공");			
			return "redirect:/";
		} catch (Exception e) {
			System.out.println("프로젝트 만들기 실패");
			e.printStackTrace();
			return "redirect:insertProductForm";
		}
      }

      
    //프로젝트목록
  	@GetMapping(value="/productList")
  	public String getProductList(Model model, HttpServletRequest request) {
  		System.out.println("프로젝트목록");

  	    List<ProductDto> list = productService.getProductList();
  	    model.addAttribute("list", list);

  	    return "productList"; 
  	}
  	
  	//프로젝트 상세보기
  	@GetMapping(value = "/productDetail")
  	public String productDetail(int seq, Model model) {
  		ProductDto dto = productService.productDetail(seq);
  		
  		model.addAttribute("dto",productService.productDetail(seq));
  		return "productDetail";
  	}
}





