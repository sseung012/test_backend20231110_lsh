package com.hk.otter.service;

import com.hk.otter.command.InsertProductCommand;


public interface IProductService {
	
	// 프로젝트 만들기
    public boolean insertProduct(InsertProductCommand insertCalCommand) throws Exception;

}
