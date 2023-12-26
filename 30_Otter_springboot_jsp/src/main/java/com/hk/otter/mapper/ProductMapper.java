package com.hk.otter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.ProductDto;

@Mapper
public interface ProductMapper {
	
	// 프로젝트 추가
	public int insertProduct(ProductDto dto);

	public List<ProductDto> getProductList();

}
