package com.hk.trip.command;


import java.util.Arrays;
import jakarta.validation.constraints.NotEmpty;

public class DelBoardCommand {

	@NotEmpty(message = "최소 하나 이상 체크해야 합니다.")
	private String[] board_seq;

	public DelBoardCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DelBoardCommand(@NotEmpty(message = "최소 하나 이상 체크해야 합니다.") String[] board_seq) {
		super();
		this.board_seq =board_seq;
	}

	public String[] getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(String[] board_seq) {
		this.board_seq = board_seq;
	}

	@Override
	public String toString() {
		return "DelBoardCommand [board_seq=" + Arrays.toString(board_seq) + "]";
	}
	
	
}