package com.hk.otter.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.OrderDto;

@Mapper
public interface OrderMapper {

	//내가 펀딩참여한 프로젝트 표로 보여주기
	public List<OrderDto> paylist(String userID);

	public OrderDto orderDetail(int seq);

}
