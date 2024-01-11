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
import com.hk.otter.command.OrderCommand;
import com.hk.otter.dtos.OrderDto;
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
   //결제

   @PostMapping(value = "/payment")
   public String productDetail( Model model, HttpSession session,String[] reward_name,String[] count,String total_price ) {
         
//      System.out.println(Arrays.toString(reward_name)+"\n"
//                      +Arrays.toString(count)+"\n"
//                      +total_price);
   
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
      
//      int seq=dto.getSeq();

      odto=orderService.orderDetail(seq);
      model.addAttribute("odto", odto);
      
      return "orderDetail";
   }

   @GetMapping("/success")
    public String OrderSuccess(OrderCommand orderCommand,
            @RequestParam("orderId") String orderId,
            @RequestParam("paymentKey") String paymentKey ) {
      
      System.out.println("success" );
   
        return "success";

    }
   
    //결제내역DB저장
    @PostMapping("/orderSave")
    public String orderSave(HttpSession session, OrderCommand orderCommand, Model model) {
      
	   	System.out.println("User ID: " + orderCommand.getUser_id());
        System.out.println("User_name: " + orderCommand.getUser_name());
        System.out.println("Title: " + orderCommand.getTitle());
        System.out.println("Selected Reward: " + orderCommand.getSelect_reward());
        System.out.println("Selected Amount: " + orderCommand.getSelect_amount());
        System.out.println("Address1: " + orderCommand.getAddress1());
        System.out.println("Address2: " + orderCommand.getAddress2());
        System.out.println("Address3: " + orderCommand.getAddress3());
        System.out.println("Phone: " + orderCommand.getPhone());
        System.out.println("Total Price: " + orderCommand.getTotal_price());
        System.out.println("Reward Seq: " + orderCommand.getReward_seq());

        // 여기서 주문 정보를 DB에 저장하는 코드를 추가하면 됩니다.
         orderService.saveOrder(orderCommand); 

        // 예시: 저장 성공 메시지를 모델에 추가
        model.addAttribute("saveSuccess", true);
        
        session.setAttribute("user_id", orderCommand.getUser_id());
        session.setAttribute("user_name", orderCommand.getUser_name());
        session.setAttribute("title", orderCommand.getTitle());
        session.setAttribute("select_reward", Arrays.asList(orderCommand.getSelect_reward()));
        session.setAttribute("address1", orderCommand.getAddress1());
        session.setAttribute("address2", orderCommand.getAddress2());
        session.setAttribute("address3", orderCommand.getAddress3());
        session.setAttribute("phone", orderCommand.getPhone());
        session.setAttribute("total_price", orderCommand.getTotal_price());
   
        return "redirect:/banking/payment2";

    }

    @GetMapping("/payment2")
    public String payment2( Model model, HttpSession session,String[] reward_name,String[] count,String total_price, String title) {
    	
    	 model.addAttribute("reward_name", reward_name);
         model.addAttribute("count", count);
         model.addAttribute("total_price", session.getAttribute("total_price"));
         model.addAttribute("title", session.getAttribute("title"));
        return "payment2";
    }
   
   @GetMapping("/confirm")
    public String confirm(@RequestParam("orderId") String orderId,
                     @RequestParam("paymentKey") String paymentKey, Model model ) {
      
      System.out.println("confirm");
      
      // 클라이언트로 전달하기 위한 model 저장
       model.addAttribute("orderId", orderId);
       model.addAttribute("paymentKey", paymentKey);

       // 콘솔에 찍히는지 확인
       System.out.println("ORDER_ID:" + orderId);
       System.out.println("PAYMENT_KEY:" + paymentKey);
      
        return "paylist";

    }
   

}