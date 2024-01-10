package com.hk.otter.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.dtos.UserDto;
import com.hk.otter.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
   
	@GetMapping(value = "/insertProductForm")
      public String insertProductForm(Model model, InsertProductCommand insertProductCommand) {
         // logger.info("프로젝트만들기폼이동");
         System.out.println(insertProductCommand);
         
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
        	// 'yyyy-MM-dd' 형식의 문자열을 LocalDate로 변환
            LocalDate closeDate = LocalDate.parse(insertProductCommand.getClose_date());
             
            // 'yyyymmdd' 형식으로 변환
            String formattedCloseDate = closeDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
             
            // InsertProductCommand에 'yyyymmdd' 형식으로 변환한 날짜를 다시 설정
            insertProductCommand.setClose_date(formattedCloseDate);
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
  	@GetMapping(value = "/productDetail/{seq}")
  	public String productDetail(@PathVariable("seq") Integer seq, Model model) {

  		System.out.println("프로젝트상세보기");
  		ProductDto dto = productService.productDetail(seq);
  		
  		List<RewardDto> rlist = (List<RewardDto>) productService.rewardOption(seq);
		model.addAttribute("rlist", rlist);
 		
  		model.addAttribute("dto",dto);
  		return "productDetail";

  	}
  	
  	
  // 내프로젝트목록
  	@GetMapping(value="/myProject")
  	public String myProject(ProductDto dto, Model model, HttpServletRequest request) {
  		System.out.println("프로젝트목록");

		HttpSession session = request.getSession();
		UserDto ldto = (UserDto)session.getAttribute("ldto");
		request.setAttribute("dto", ldto);
		
		// 사용자가 로그인되어 있지 않은 경우 로그인 페이지로 리다이렉트
		if (ldto == null) {
			return "redirect:/user/signin";
		}
		
		int userSeq=ldto.getSeq();
  		
  	    List<ProductDto> list = productService.myProject(userSeq);
  	    model.addAttribute("mylist", list);
  	    System.out.println("mylist:"+list);


  	    return "myProject"; 
  	}
  	
  //카테고리별 프로젝트목록
  	@GetMapping(value="/category")
  	public String Category (Model model,String cate_seq) {
  		System.out.println("카테고리별 프로젝트목록");
  	    List<ProductDto> list = productService.category(cate_seq);
  	    model.addAttribute("clist", list);
  	    System.out.println("clist:"+list);
  	    
//  	    if(cate_seq==null) {
//  	    	list=productService.category(cate_seq);
//  	    }

  	    return "category";   
  	}
  	
  	//승인하기
  	@GetMapping(value = "/approve/{seq}")
  	public String approve(@PathVariable int seq) {
  	   boolean isS = productService.approve(seq);

  	   if (isS) {
  	       return "redirect:/product/productList"; // 승인 성공 시 productList 페이지로 리다이렉트
  	   } else {
  	       System.out.println("수정 실패 메시지 또는 다른 처리를 추가하세요");
  	       return "redirect:/productDetail"; // 승인 실패 시 productDetail 페이지로 리다이렉트
  	   }
  	}
  	
  	// 리워드 수량/금액
  	
  	
}



