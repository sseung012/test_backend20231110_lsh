package com.hk.otter.controller;


import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.command.SuccessCommand;
import com.hk.otter.dtos.OrderDto;
import com.hk.otter.dtos.ProductDto;
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
	
	private static final SuccessCommand SuccessCommand = null;

	@Autowired 
	private OpenBankingFeign openBankingFeign;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	//결제

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

		return  "paylist";
	}
	
//	@GetMapping("/success")
	@RequestMapping(value="/success", method = {RequestMethod.GET, RequestMethod.POST})
	public String orderSuccess(SuccessCommand successCommand, Model model, HttpServletRequest request) throws IllegalStateException, IOException {
		
		try {
			System.out.println(successCommand);
//			LocalDate Order_date = LocalDate.parse(successCommand.getOrder_date());
//			String formattedDate = Order_date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//			successCommand.setOrder_date(formattedDate);
			System.out.println("결제진행");
			HttpSession session = request.getSession();
			
			
			UserDto ldto = (UserDto)session.getAttribute("ldto");
			request.setAttribute("ldto", ldto);

			// 사용자가 로그인되어 있지 않은 경우 로그인 페이지로 리다이렉트
			if (ldto == null) {
				return "redirect:/user/signin";
			}

//			System.out.println("Seq:" + successCommand.getSeq());
//			System.out.println("User ID: " + successCommand.getUser_id());
//	        System.out.println("User_name: " + successCommand.getUser_name());
//	        System.out.println("Title: " + successCommand.getTitle());
//	        System.out.println("Selected Reward: " + successCommand.getSelect_reward());
//	        System.out.println("Selected Amount: " + successCommand.getSelect_amount());
//	        System.out.println("Address: " + successCommand.getAddress());
//	        System.out.println("Phone: " + successCommand.getPhone());
//	        System.out.println("Total Price: " + successCommand.getTotal_price());
//	        System.out.println("Reward Seq: " + successCommand.getReward_seq());
			System.out.println("OrderID: " + successCommand.getOrderId());

	        // 예시: 저장 성공 메시지를 모델에 추가
			System.out.println("결제 성공");		
			OrderDto odto = (OrderDto)session.getAttribute("odto");
//			request.setAttribute("odto", odto);
			
//			orderService.orderSuccess(successCommand, model, request);
			model.addAttribute("orderSuccess", true);
			List<OrderDto> oddto= (List<OrderDto>)orderService.orderSuccess(odto);
			model.addAttribute("oddto", oddto);
			session.setAttribute("oddto",oddto);

			return "success";
			
		} catch (IllegalStateException e) {
			System.out.println("결제 실패");
			e.printStackTrace();
			return "/";
		}

	}
	
	
	
//	@PostMapping(value = "/success")
//    public String orderSuccess(SuccessCommand successCommand,
//                         MultipartRequest multipartRequest
//            			  , Model model, HttpServletRequest request)throws Exception { 
//		System.out.println(successCommand);
//         try {
//        	// 'yyyy-MM-dd' 형식의 문자열을 LocalDate로 변환
//            LocalDate closeDate = LocalDate.parse(successCommand.getOrder_date());
//             
//            // 'yyyymmdd' 형식으로 변환
//            String formattedCloseDate = closeDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//             
//            // InsertProductCommand에 'yyyymmdd' 형식으로 변환한 날짜를 다시 설정
//            successCommand.setOrder_date(formattedCloseDate);
//			orderService.orderSuccess(successCommand, multipartRequest, request);
//			System.out.println("결제 성공");			
//			return "success";
//		} catch (Exception e) {
//			System.out.println("결제 실패");
//			e.printStackTrace();
//			return "/";
//		}
//      }
 
	
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

		odto=orderService.orderDetail(seq);
		model.addAttribute("odto", odto);
		System.out.println("odto:"+odto);
		
		return "orderDetail";
	}

//	@GetMapping("/success")
//    public String orderSucces(OrderDto orderDto,
//    					  @RequestParam("orderId") String orderId,
//                          @RequestParam("paymentKey") String paymentKey,
//                          @RequestParam("user_id") String user_id,
//                          Model model, HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("success 컨트롤러 시작");
//
//	    // 클라이언트로 전달하기 위한 model 저장
//	    model.addAttribute("orderId", orderId);
//	    model.addAttribute("paymentKey", paymentKey);
//
//	    // 콘솔에 찍히는지 확인
//	    System.out.println("ORDER_ID:" + orderId);
//	    System.out.println("PAYMENT_KEY:" + paymentKey);
//
//	    orderDto.setUser_id(user_id); 
//	    orderDto.setOrderId(orderId);
//	    orderDto.setPaymentKey(paymentKey);
//
//	    request.getSession().setAttribute("dto", orderDto);
//	    System.out.println(orderDto);
//	    orderService.orderSuccessok(orderDto);
//
//	    System.out.println("dto : " + orderDto);
//
//	    return "success";
//    }
//	
	
	
	@GetMapping("/fail")
    public String fail() {


        return "fail";
    }

}
