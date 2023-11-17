package com.hk.trip.command;

import jakarta.validation.constraints.NotBlank;

public class UpdateBoardCommand {

	private int board_seq;
	
	@NotBlank(message = "제목을 입력하세요.")
	private String title;
	
	@NotBlank(message = "내용을 입력하세요.")
	private String content;
}
