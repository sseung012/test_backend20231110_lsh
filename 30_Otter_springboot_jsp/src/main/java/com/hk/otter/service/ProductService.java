package com.hk.otter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.otter.command.InsertProductCommand;

import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;
import com.hk.otter.dtos.UserDto;
import com.hk.otter.mapper.ProductMapper;
import com.hk.otter.mapper.RewardMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProductService {
		
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private RewardMapper rewardMapper;
	
	@Autowired
	private FileService fileService;
	
	@Transactional
	public void insertProduct(InsertProductCommand insertProductCommand, 
			MultipartRequest multipartRequest,
			HttpServletRequest request) {
		
		ProductDto pdto = new ProductDto();

		//productDto <---command 이동
		pdto.setImg(insertProductCommand.getImg());
		pdto.setMaker(insertProductCommand.getMaker());
		pdto.setGoal_price(insertProductCommand.getGoal_price());
		pdto.setTitle(insertProductCommand.getTitle());
		pdto.setCreated_date(insertProductCommand.getCreated_date()); //string-->date타입(java.util.Date,java.sql.Date)
		pdto.setClose_date(insertProductCommand.getClose_date());
		pdto.setContent(insertProductCommand.getContent());
		pdto.setCate_seq(insertProductCommand.getCate_seq());
		
		//rewardDto <---command 이동
		//list<rewardDto> 저장
		List<RewardDto> reList=new ArrayList<RewardDto>();
		
		productMapper.insertProduct(pdto); //새 글 추가
		
		System.out.println("파일첨부여부: " + multipartRequest.getFiles("img").get(0).isEmpty());
		
	if(!multipartRequest.getFiles("img").get(0).isEmpty()) {
			String filePath = request.getSession().getServletContext()
									.getRealPath("upload");
			System.out.println("파일저장경로: " + filePath);
			
			// 파일 업로드 작업은 FileService에서 업로드
			// 업로드된 파일 정보 반환
//			List<ProductDto> reList 
			fileService.uploadFiles(filePath, multipartRequest);
			
			
			// 리워드 정보를 DB에 추가
			for(RewardDto rdto : reList) {
//				rewardMapper.insertReward(
//						new RewardDto(rdto.getReward_name(),
//									  rdto.getPrice(),
//									  rdto.getCombination(),
//									  rdto.getStock(),
//									  pdto.getSeq()));			
			}
		}
	}

	public List<ProductDto> getProductList() {
		return productMapper.getProductList();
	}

}


