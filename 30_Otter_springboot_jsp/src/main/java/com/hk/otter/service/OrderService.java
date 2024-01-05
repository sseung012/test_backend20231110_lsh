package com.hk.otter.service;

import java.util.List;

import com.hk.otter.dtos.OrderDto;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.mapper.OrderMapper;

public class OrderService {

	public static List<OrderDto> paylist() {
		return OrderMapper.paylist();
	}

}
