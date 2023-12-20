package com.hk.otter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.otter.command.InsertRewardCommand;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.mapper.RewardMapper;

@Service
public class RewardService {
	
	@Autowired
	private RewardMapper rewardMapper;
	
	public int insertReward(InsertRewardCommand insertRewardCommand) {
		RewardDto rdto = new RewardDto();
		rdto.setReward_name(insertRewardCommand.getReward_name());
		rdto.setPrice(insertRewardCommand.getPrice());
		rdto.setCombination(insertRewardCommand.getCombination());
		rdto.setStock(insertRewardCommand.getStock());
		
		return rewardMapper.insertReward(rdto);
	}

}
