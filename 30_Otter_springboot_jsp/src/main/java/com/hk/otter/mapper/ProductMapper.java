package com.hk.otter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.ProductDto;

@Mapper
public interface ProductMapper {
	
	// 프로젝트 추가
	public int insertProduct(ProductDto dto);
	//관리자-프로젝트관리
	public List<ProductDto> getProductList();
	//인덱스-프로젝트 작게조회
	public List<ProductDto> getProductMini();

}
