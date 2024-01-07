package com.hk.otter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.otter.dtos.RewardDto;
import com.hk.otter.mapper.ProductMapper;
import com.hk.otter.mapper.RewardMapper;
import com.hk.otter.mapper.UserMapper;

@Service
public class PaymentService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private RewardMapper rewardMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public List<RewardDto> rewardOption(int seq){
		return rewardMapper.rewardOption(seq);
	}
	
}
