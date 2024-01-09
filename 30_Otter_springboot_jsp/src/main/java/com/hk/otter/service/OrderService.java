package com.hk.otter.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.command.OrderCommand;
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
	public List<OrderDto> paylist(String user_id) {
		return orderMapper.paylist(user_id);
	}

	public OrderDto orderDetail(int seq) {
		return orderMapper.orderDetail(seq);
	}

//	@Transactional
	public boolean orderSuccess(OrderCommand orderCommand) {
        // 여기에 주문 성공 처리 로직을 작성
        // 주문 정보를 데이터베이스에 저장하거나, 상태를 업데이트하거나 등등...

		OrderDto odto=new OrderDto();
		odto.setUser_id(orderCommand.getUser_id());
		odto.setUser_name(orderCommand.getUser_name());
		odto.setTitle(orderCommand.getTitle());
		odto.setSelect_reward(orderCommand.getSelect_reward());
		odto.setSelect_amount(orderCommand.getSelect_amount());
		odto.setAddress1(orderCommand.getAddress1());
		odto.setAddress2(orderCommand.getAddress2());
		odto.setAddress3(orderCommand.getAddress3());
		odto.setPhone(orderCommand.getPhone());
		odto.setTotal_price(orderCommand.getTotal_price());

		
        try {
        	orderMapper.orderSuccess(odto);
                   
            return true;
        } catch (Exception e) {
            // 주문 성공 처리 중 예외 발생 시 실패로 간주
            e.printStackTrace();
            return false;
        }
    }

	//결제정보 DB저장
	public void saveOrder(OrderCommand orderCommand) {
		OrderDto odto = new OrderDto();
		odto.setUser_id(orderCommand.getUser_id());
		odto.setUser_name(orderCommand.getUser_name());
		odto.setTitle(orderCommand.getTitle());
		odto.setSelect_reward(orderCommand.getSelect_reward());
		odto.setSelect_amount(orderCommand.getSelect_amount());
		odto.setAddress1(orderCommand.getAddress1());
		odto.setAddress2(orderCommand.getAddress2());
		odto.setAddress3(orderCommand.getAddress3());
		odto.setPhone(orderCommand.getPhone());
		odto.setTotal_price(orderCommand.getTotal_price());
		odto.setReward_seq(orderCommand.getReward_seq());

		orderMapper.saveOrder(odto);
	}

}
