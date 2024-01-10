package com.hk.otter.command;

import jakarta.validation.constraints.NotBlank;

public class OrderCommand {
	
	public int seq;
	public String user_id;
	public String user_name;
	public String title;
	public String select_reward;
	public int select_amount;
	@NotBlank(message = "배송지를 등록하세요!")
	public String address;
	@NotBlank(message = "전화번호를 등록하세요!")
	public String phone; 
	public int total_price;
	public int reward_seq;
	public String order_date;

	//결제정보 db에저장
	public OrderCommand(int seq, String user_id, String user_name, String title, String select_reward,
		 String address1, String address2, @NotBlank(message = "배송지를 등록하세요!") String address3, @NotBlank(message = "전화번호를 등록하세요!") String phone,
			int total_price) {
		super();
		this.seq = seq;
		this.user_id = user_id;
		this.user_name = user_name;
		this.title = title;
		this.select_reward = select_reward;
		this.address = address;
		this.phone = phone;
		this.total_price = total_price;
	}
	
	public OrderCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderCommand(int seq, String user_id, String user_name, String title, String select_reward, int select_amount,
			@NotBlank(message = "배송지를 등록하세요!") String address, @NotBlank(message = "전화번호를 등록하세요!") String phone,
			int total_price, int reward_seq) {
		super();
		this.seq = seq;
		this.user_id = user_id;
		this.user_name = user_name;
		this.title = title;
		this.select_reward = select_reward;
		this.select_amount = select_amount;
		this.address = address;
		this.phone = phone;
		this.total_price = total_price;
		this.reward_seq = reward_seq;

	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSelect_reward() {
		return select_reward;
	}

	public void setSelect_reward(String select_reward) {
		this.select_reward = select_reward;
	}

	public int getSelect_amount() {
		return select_amount;
	}

	public void setSelect_amount(int select_amount) {
		this.select_amount = select_amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getReward_seq() {
		return reward_seq;
	}

	public void setReward_seq(int reward_seq) {
		this.reward_seq = reward_seq;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	@Override
	public String toString() {
		return "OrderCommand [seq=" + seq + ", user_id=" + user_id + ", user_name=" + user_name + ", title=" + title
				+ ", select_reward=" + select_reward + ", select_amount=" + select_amount + ", address=" + address
				+ ", phone=" + phone + ", total_price=" + total_price + ", reward_seq=" + reward_seq + ", order_date="
				+ order_date + "]";
	}
}