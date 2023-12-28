package com.hk.otter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;

@Mapper
public interface RewardMapper {
	
	
	// 리워드 추가하기
	public int insertReward(RewardDto dto);
	
	// 리워드 상세보기
	public RewardDto rewardDetail(int seq);
	
	// 리워드 옵션 불러오기
	public List<RewardDto> rewardOption(int seq);
	
}
