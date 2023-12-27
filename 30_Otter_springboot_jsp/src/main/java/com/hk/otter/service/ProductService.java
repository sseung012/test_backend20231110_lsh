package com.hk.otter.service;

import java.io.IOException;
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
import jakarta.servlet.http.HttpSession;

@Service
public class ProductService {
		
	
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private RewardMapper rewardMapper;
	
	@Autowired
	private FileService fileService;
	
	// 프로젝트 등록
	@Transactional
	public void insertProduct(InsertProductCommand insertProductCommand, 
			MultipartRequest multipartRequest,
			HttpServletRequest request) throws IllegalStateException, IOException {
		
		ProductDto pdto = new ProductDto();
		
		String img=multipartRequest.getFile("img").getOriginalFilename();
		//productDto <---command 이동
		pdto.setImg(img);
		pdto.setUser_seq(insertProductCommand.getUser_seq());
		pdto.setMaker(insertProductCommand.getMaker());
		pdto.setGoal_price(insertProductCommand.getGoal_price());
		pdto.setTitle(insertProductCommand.getTitle());
//		pdto.setCreated_date(insertProductCommand.getCreated_date()); //string-->date타입(java.util.Date,java.sql.Date)
		pdto.setClose_date(insertProductCommand.getClose_date());
		pdto.setContent(insertProductCommand.getContent());
		pdto.setCate_seq(insertProductCommand.getCate_seq());
		

		productMapper.insertProduct(pdto); //새 글 추가
		System.out.println("product_seq:"+pdto.getSeq());
		//rewardDto <---command 이동
		//list<rewardDto> 저장
		List<RewardDto> reList=new ArrayList<RewardDto>();
		for (int i = 0; i < insertProductCommand.getReward_name().length; i++) {
			RewardDto rdto = new RewardDto(insertProductCommand.getReward_name()[i],
					insertProductCommand.getPrice()[i],
					insertProductCommand.getCombination()[i],
					insertProductCommand.getStock()[i],
					pdto.getSeq());
			reList.add(rdto);
		}
		System.out.println(reList.get(0));
		// 리워드 정보를 DB에 추가
		for(RewardDto rrdto : reList) {
			rewardMapper.insertReward(rrdto);			
		}
		
		System.out.println("파일첨부여부: " + multipartRequest.getFiles("img").get(0).isEmpty());
		
	if(!multipartRequest.getFiles("img").get(0).isEmpty()) {
			String filePath = request.getSession().getServletContext()
									.getRealPath("upload");
			System.out.println("파일저장경로: " + filePath);
			
			// 파일 업로드 작업은 FileService에서 업로드
			// 업로드된 파일 정보 반환
//			List<ProductDto> reList 
			fileService.uploadFiles(filePath, multipartRequest);		
		}
	}
	
	
	// 프로젝트 상세조회
	@Transactional
	public ProductDto productDetail(Integer seq) {
		return productMapper.productDetail(seq);
	}

	//프로젝트 조회
	public List<ProductDto> getProductList() {
		return productMapper.getProductList();
	}


}


