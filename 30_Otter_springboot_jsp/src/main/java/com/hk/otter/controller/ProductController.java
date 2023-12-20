package com.hk.otter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.otter.command.InsertProductCommand;

@Controller
@RequestMapping("/product")
public class ProductController {
   
   @GetMapping(value = "/insertProductForm")
      public String addCalBoardForm(Model model, InsertProductCommand insertProductCommand) {
         // logger.info("프로젝트만들기폼이동");
         System.out.println(insertProductCommand);
         
         // addCalBoardfForm 페이지에서 유효값 처리를 위해 
         // insertCalCommand 받고 있기 때문에 보내줘야 해!
         model.addAttribute("insertProductCommand", insertProductCommand);
         return "/product/addProductForm";
      }
      
      
      @PostMapping(value = "/insertProduct")
      public String insertProduct(@Validated InsertProductCommand insertProductCommand,
                          BindingResult result)throws Exception {
    	  
         // 파라미터 순서 꼭 맞춰줄 것!
         // logger.info("일정추가하기");
         System.out.println(insertProductCommand);
         
         if(result.hasErrors()) { // 에러가 있으면 돌려보냄
            System.out.println("글을 모두 입력해야 함");
            return "thymeleaf/product/addProductForm";
         }
         
         return null;
         
         // 정상적으로 처리가 된다면
//         calService.insertCalBoard(insertCalCommand);
//         
//         return "redirect:/schedule/calendar?year="+insertCalCommand.getYear()
//         +"&month="+insertCalCommand.getMonth();
      }

}





