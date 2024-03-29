package com.hk.otter.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hk.otter.dtos.OrderDto;

@Mapper
public interface OrderMapper {

	//내가 펀딩참여한 프로젝트 표로 보여주기
	public List<OrderDto> paylist(String user_id);

	public OrderDto orderDetail(int seq);

	public int orderSuccess(OrderDto dto);
	
	public OrderDto orderSuccessok(OrderDto dto);
	

	public void saveOrder(OrderDto odto);

	public void addToTotalPrice(@Param("Seq") int Seq, @Param("totalPrice") int totalPrice);

}
