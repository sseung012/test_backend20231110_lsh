package com.hk.otter.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.ProductDto;

@Mapper
public interface ProductMapper {
	
	// 프로젝트 추가
	public int insertProduct(ProductDto dto);

}
