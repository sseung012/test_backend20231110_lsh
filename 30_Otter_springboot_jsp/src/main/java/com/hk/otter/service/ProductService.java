package com.hk.otter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.otter.command.InsertProductCommand;
import com.hk.otter.dtos.ProductDto;
import com.hk.otter.mapper.ProductMapper;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductMapper productMapper;
	
	public int insertProduct(InsertProductCommand insertProductCommand) {
		ProductDto pdto = new ProductDto();
		pdto.setImg(insertProductCommand.getImg());
		pdto.setMaker(insertProductCommand.getMaker());
		pdto.setGoal_price(insertProductCommand.getGoal_price());
		pdto.setTitle(insertProductCommand.getTitle());
		pdto.setClose_date(insertProductCommand.getClose_date());
		pdto.setContent(insertProductCommand.getContent());
		
		return productMapper.insertProduct(pdto);
	}

}
