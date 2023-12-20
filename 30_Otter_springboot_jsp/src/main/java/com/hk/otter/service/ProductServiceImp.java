package com.hk.otter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.mapper.ProductMapper;

@Service
public class ProductServiceImp {
	
	@Autowired
	private ProductMapper productMapper;
	
//	@Override
//	public boolean insertProduct(InsertProductCommand insertCalCommand) throws Exception {
//	      // command --> dto로 값 이동
//	      
//	      String startdate = insertCalCommand.getYears()
//	            + Util.isTwo(insertCalCommand.getMonths()+"")   
//	            + Util.isTwo(insertCalCommand.getDates()+"");
//	      
//	      
//	      String enddate = insertCalCommand.getYear()
//	              + Util.isTwo(insertCalCommand.getMonth()+"")   
//	              + Util.isTwo(insertCalCommand.getDate()+"")
//	              
//	      // 202311151335_12자리
//	      // 20231181110_11자리 => 이를 방지하기 위해 Util 클래스 생성
//	      
//	      // command --> dto 값 복사
//	      ProductDto dto = new ProductDto();
//	      dto.setId(insertCalCommand.getId());
//	      dto.setTitle(insertCalCommand.getTitle());
//	      dto.setContent(insertCalCommand.getContent());
//	      dto.setCategory(insertCalCommand.getCategory());
//	      dto.setStartdate(startdate); 
//	      dto.setEnddate(enddate);
//	      
//	      int count = calMapper.insertCalBoard(dto);
//	      
//	      return count>0?true:false;
//	      
//	}

}
