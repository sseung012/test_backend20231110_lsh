package com.hk.otter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.otter.dtos.OrderDto;
import com.hk.otter.mapper.OrderMapper;


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

	public boolean orderSuccess(OrderDto dto) {
		int count=orderMapper.orderSuccess(dto);
		return count>0?true:false;
	}

}
