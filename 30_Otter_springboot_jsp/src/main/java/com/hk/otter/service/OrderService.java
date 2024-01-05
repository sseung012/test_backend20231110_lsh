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

}
