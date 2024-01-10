package com.hk.otter.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.command.SuccessCommand;
import com.hk.otter.dtos.OrderDto;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.mapper.OrderMapper;

import jakarta.servlet.http.HttpServletRequest;


@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Transactional
	public List<OrderDto> paylist(String userID) {
		return orderMapper.paylist(userID);
	}

	public OrderDto orderDetail(int seq) {
		return orderMapper.orderDetail(seq);
	}
	
	@Transactional
	public void orderSuccessok(SuccessCommand successCommand, Model model, HttpServletRequest request)throws IllegalStateException, IOException {
		OrderDto odto= new OrderDto();
		odto.setSeq(successCommand.getSeq());
		odto.setUser_id(successCommand.getUser_id());
		odto.setUser_name(successCommand.getUser_name());
		odto.setTitle(successCommand.getTitle());
		odto.setSelect_reward(successCommand.getSelect_reward());
		odto.setSelect_amount(successCommand.getSelect_amount());
		odto.setAddress(successCommand.getAddress());
		odto.setPhone(successCommand.getPhone());
		odto.setTotal_price(successCommand.getTotal_price());
		odto.setOrder_date(successCommand.getOrder_date());
		odto.setOrderId(successCommand.getOrderId());
		odto.setPaymentKey(successCommand.getPaymentKey());
		orderMapper.orderSuccess(odto);

	}


//	public OrderDto orderSuccessok(OrderDto dto) {
//		return orderMapper.orderSuccessok(dto);
//	}

	public void orderSuccessok(SuccessCommand successCommand, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	public List<OrderDto> orderSuccess(OrderDto odto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
