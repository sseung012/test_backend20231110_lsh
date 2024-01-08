package com.hk.otter.controller;


import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
   
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.otter.dtos.OrderDto;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.dtos.UserDto;
import com.hk.otter.feignMapper.OpenBankingFeign;
import com.hk.otter.service.OrderService;
import com.hk.otter.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/banking")
public class FundingController {
	
	@Autowired
	private OpenBankingFeign openBankingFeign;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	

	@PostMapping(value = "/payment")
	public String productDetail( Model model, HttpSession session,String[] reward_name,String[] count,String total_price ) {
			
//		System.out.println(Arrays.toString(reward_name)+"\n"
//				          +Arrays.toString(count)+"\n"
//				          +total_price);
	
		model.addAttribute("reward_name", reward_name);
		model.addAttribute("count", count);

		return  "payment" ;
	}

	//주문목록 리스트로 보기
	@GetMapping(value = "/paylist")
	public String paylist(Model model, HttpServletRequest request) {
		System.out.println("사용자-참여한 펀딩 목록");

		HttpSession session = request.getSession();
		UserDto ldto = (UserDto)session.getAttribute("ldto");
		request.setAttribute("dto", ldto);
		
		// 사용자가 로그인되어 있지 않은 경우 로그인 페이지로 리다이렉트
		if (ldto == null) {
			return "redirect:/user/signin";
		}
		
		String userID=ldto.getId();
  		
  	    List<OrderDto> list = orderService.paylist(userID);
  	    model.addAttribute("list", list);
  	    System.out.println("list:"+list);

		return  "paylist" ;
	}
	
	//결제내역 상세보기
	@GetMapping("/orderDetail/{seq}")
	public String orderDetail(@PathVariable("seq") Integer seq, OrderDto odto, Model model, HttpServletRequest request) {
		System.out.println("결제내역 상세보기");
		HttpSession session = request.getSession();
		OrderDto dto = (OrderDto)session.getAttribute("dto");
		request.setAttribute("dto", dto);

		UserDto ldto = (UserDto)session.getAttribute("ldto");
		request.setAttribute("dto", ldto);
		
		// 사용자가 로그인되어 있지 않은 경우 로그인 페이지로 리다이렉트
		if (ldto == null) {
			return "redirect:/user/signin";
		}
		
//		int seq=dto.getSeq();

		odto=orderService.orderDetail(seq);
		model.addAttribute("odto", odto);
		
		return "orderDetail";
	}

	@GetMapping("/success")
    public String success(OrderDto orderDto,
    					  @RequestParam("orderId") String orderId,
                          @RequestParam("paymentKey") String paymentKey,
                          @RequestParam("user_id") String user_id,
                          Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("success 컨트롤러 시작");

	    // 클라이언트로 전달하기 위한 model 저장
	    model.addAttribute("orderId", orderId);
	    model.addAttribute("paymentKey", paymentKey);

	    // 콘솔에 찍히는지 확인
	    System.out.println("ORDER_ID:" + orderId);
	    System.out.println("PAYMENT_KEY:" + paymentKey);

	    orderDto.setUser_id(user_id); 
	    orderDto.setOrderId(orderId);
	    orderDto.setPaymentKey(paymentKey);

	    request.getSession().setAttribute("dto", orderDto);
	    System.out.println(orderDto);
	    orderService.orderSuccess(orderDto);

	    System.out.println("dto : " + orderDto);

	    return "success";
    }
	
	@GetMapping("/fail")
    public String fail() {


        return "fail";
    }
	
}
