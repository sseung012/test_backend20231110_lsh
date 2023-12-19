package com.hk.otter.dtos;

public class UserDto {
	
	private int seq;
	private String id;
	private String userpassword;
	private String username;
	private String phone;
	private String useremail;
	
	private String useraccesstoken; // 접근을 위한 토큰
	private String userrefreshtoken;// 갱신을 위한 토큰
	private int userseqno; // 사용자일련번호
	private String role;
	private String delflag;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int seq, String id, String userpassword, String username, String phone, String useremail,
			String useraccesstoken, String userrefreshtoken, int userseqno, String role, String delflag) {
		super();
		this.seq = seq;
		this.id = id;
		this.userpassword = userpassword;
		this.username = username;
		this.phone = phone;
		this.useremail = useremail;
		this.useraccesstoken = useraccesstoken;
		this.userrefreshtoken = userrefreshtoken;
		this.userseqno = userseqno;
		this.role = role;
		this.delflag = delflag;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getUseraccesstoken() {
		return useraccesstoken;
	}

	public void setUseraccesstoken(String useraccesstoken) {
		this.useraccesstoken = useraccesstoken;
	}

	public String getUserrefreshtoken() {
		return userrefreshtoken;
	}

	public void setUserrefreshtoken(String userrefreshtoken) {
		this.userrefreshtoken = userrefreshtoken;
	}

	public int getUserseqno() {
		return userseqno;
	}

	public void setUserseqno(int userseqno) {
		this.userseqno = userseqno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "UserDto [seq=" + seq + ", id=" + id + ", userpassword=" + userpassword + ", username=" + username
				+ ", phone=" + phone + ", useremail=" + useremail + ", useraccesstoken=" + useraccesstoken
				+ ", userrefreshtoken=" + userrefreshtoken + ", userseqno=" + userseqno + ", role=" + role
				+ ", delflag=" + delflag + "]";
	}
	
	
	
	
}