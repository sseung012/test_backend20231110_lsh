package com.hk.otter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.command.InsertRewardCommand;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.dtos.UserDto;
import com.hk.otter.mapper.ProductMapper;
import com.hk.otter.mapper.RewardMapper;

@Service
public class ProductService {
		
	@Autowired
	private ProductMapper productMapper;
	
	public int insertProduct(InsertProductCommand insertProductCommand) {
		ProductDto pdto = new ProductDto();
		pdto.setImg(insertProductCommand.getImg());
		pdto.setMaker(insertProductCommand.getMaker());
		pdto.setGoal_price(insertProductCommand.getGoal_price());
		pdto.setTitle(insertProductCommand.getTitle());
		pdto.setClose_date(insertProductCommand.getClose_date());
		pdto.setContent(insertProductCommand.getContent());
		
		return productMapper.insertProduct(pdto);
	}

	
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

	//관리자-프로젝트전체조회
	public List<ProductDto> getProductList() {
		return productMapper.getProductList();
	}
}














