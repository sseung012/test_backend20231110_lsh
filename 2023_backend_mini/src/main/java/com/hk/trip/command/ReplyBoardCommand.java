package com.hk.trip.command;

import jakarta.validation.constraints.NotBlank;

public class ReplyBoardCommand {

	private int board_seq;
	
	private String id;
	@NotBlank(message = "제목을 입력하세요")
	private String title;
	@NotBlank(message = "내용을 입력하세요")
	private String content;
	
	
	public ReplyBoardCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplyBoardCommand(int board_seq, String id, @NotBlank(message = "제목을 입력하세요") String title,
			@NotBlank(message = "내용을 입력하세요") String content) {
		super();
		this.board_seq = board_seq;
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ReplyBoardCommand [board_seq=" + board_seq + ", id=" + id + ", title=" + title + ", content=" + content
				+ "]";
	}
	
	
}
