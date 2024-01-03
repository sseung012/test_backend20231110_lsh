package com.hk.otter.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hk.otter.mapper.ProductMapper;
import com.hk.otter.mapper.RewardMapper;
import com.hk.otter.mapper.UserMapper;

public class paymentService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private RewardMapper rewardMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	
}
