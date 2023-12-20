package com.hk.otter.command;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class InsertProductCommand {
	
	private int seq;
	
	private int user_seq;
	
	@NotBlank(message = "대표 이미지를 등록하세요!")
	private String img;
	
	@NotBlank(message = "회사명을 등록하세요!")
	private String maker;
	
	@NotBlank(message = "목표금액을 등록하세요!")
	private String goal_price;
	
	@NotBlank(message = "펀딩 프로젝트명을 등록하세요!")
	private String title;
	
	private Date created_date;
	
	private String open_date;
	
	@NotBlank(message = "마감일을 등록하세요!")
	private String close_date;
	
	@NotBlank(message = "상세 내용을 등록하세요!")
	private String content;
	
	private int total_price;
	
	private int total_supporters;
	
	private int cate_seq;
	
	private String product_check;
	
	
	
	

}
