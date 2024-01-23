package com.hk.calboard.command;

import java.util.Arrays;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DeleteCalCommand {
	
	//null이거나 길이가 0인 경우
	@NotEmpty(message = "삭제하려면 최소 하나 이상 선택하세요.")
	private String[] seq;

	public DeleteCalCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DeleteCalCommand [seq=" + Arrays.toString(seq) + "]";
	}

	public DeleteCalCommand(@NotEmpty(message = "삭제하려면 최소 하나 이상 선택하세요.") String[] seq) {
		super();
		this.seq = seq;
	}

	public String[] getSeq() {
		return seq;
	}

	public void setSeq(String[] seq) {
		this.seq = seq;
	}

	
}
