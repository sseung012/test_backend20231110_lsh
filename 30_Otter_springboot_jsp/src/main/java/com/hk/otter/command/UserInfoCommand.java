package com.hk.otter.command;

import jakarta.validation.constraints.NotBlank;

public class UserInfoCommand {

	private String id;

	@NotBlank(message = "전화번호를 입력하세요")
	private String phone;
    
	@NotBlank(message = "이메일을 입력하세요")
	private String useremail;

	public UserInfoCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfoCommand(String id, @NotBlank(message = "전화번호를 입력하세요") String phone,
			@NotBlank(message = "이메일을 입력하세요") String useremail) {
		super();
		this.id = id;
		this.phone = phone;
		this.useremail = useremail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	@Override
	public String toString() {
		return "UserInfoCommand [id=" + id + ", phone=" + phone + ", useremail=" + useremail + "]";
	}

	
		

}