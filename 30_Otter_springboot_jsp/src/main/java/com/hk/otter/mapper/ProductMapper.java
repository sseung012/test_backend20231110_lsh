package com.hk.otter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;

@Mapper
public interface ProductMapper {
	
	// 프로젝트 추가
	public int insertProduct(ProductDto dto);
	
	//관리자-프로젝트관리
	public List<ProductDto> getProductList();

	//인덱스-프로젝트 작게조회
	public List<ProductDto> getProductMini();
	
	// 프로젝트 상세보기	
	public ProductDto productDetail(Integer seq);

	// 리워드 옵션 불러오기
	public RewardDto rewardOption(int seq);
	
	//카테고리별조회
	public List<ProductDto> category(String cate_seq);

	//프로젝트 승인
	boolean approve(ProductDto dto);

	//내프로젝트 조회(리스트로)
	public List<ProductDto> myProject(int userSeq);

	


}
