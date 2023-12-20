package com.hk.otter.command;

import jakarta.validation.constraints.NotBlank;

public class InsertProductCommand {
	
	private int seq;
	private int user_seq;
	
	@NotBlank(message = "대표 이미지를 등록하세요!")
	private String img;

}
