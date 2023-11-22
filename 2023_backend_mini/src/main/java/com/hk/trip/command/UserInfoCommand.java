package com.hk.trip.command;

import java.util.Arrays;

public class UserInfoCommand {
	
	private String[] id;
	
	public UserInfoCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoCommand(String[] id) {
		super();
		this.id= id;

	}

	public String[] id(){
		return id;
	}

	public void setId(String[] id) {
		this.id=id;
	}

	@Override
	public String toString() {
		return "UserInfoCommand [id=" + Arrays.toString(id) + "]";
	}

}
