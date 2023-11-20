package com.hk.trip.command;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public class LoginCommand {

	@NotBlank(message = "아이디를 입력해주세요")
	private String id;
	
	@NotBlank(message = "패스워드를 입력해주세요")
	@Length(min = 8, max = 16, message = "8자 이상, 16자 이하로 입력하세요")
	private String password;
	
	
	public LoginCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginCommand(@NotBlank(message = "아이디를 입력해주세요") String id,
			@NotBlank(message = "패스워드를 입력해주세요") @Length(min = 8, max = 16, message = "8자 이상, 16자 이하로 입력하세요") String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCommand [id=" + id + ", password=" + password + "]";
	}
	
}
