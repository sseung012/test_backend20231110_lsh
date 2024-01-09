package com.hk.otter.dtos;

public class OrderDto {

	public int seq;
	public String user_id;
	public String name;
	public String title;
	public String select_reward;
	public int select_amount;
	public String address;
	public String phone; 
	public String total_price;
	public int reward_seq;
	public String order_date;
	public String orderId;
	public String paymentKey;
	
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDto(int seq, String user_id, String name, String title, String select_reward, int select_amount,
			String address, String phone, String total_price, int reward_seq, String order_date, String orderId,
			String paymentKey) {
		super();
		this.seq = seq;  
		this.user_id = user_id;
		this.name = name;
		this.title = title;
		this.select_reward = select_reward;
		this.select_amount = select_amount;
		this.address = address;
		this.phone = phone;
		this.total_price = total_price;
		this.reward_seq = reward_seq;
		this.order_date = order_date;
		this.orderId = orderId;
		this.paymentKey = paymentKey;
	}
	@Override
	public String toString() {
		return "OrderDto [seq=" + seq + ", user_id=" + user_id + ", name=" + name + ", title=" + title
				+ ", select_reward=" + select_reward + ", select_amount=" + select_amount + ", address=" + address
				+ ", phone=" + phone + ", total_price=" + total_price + ", reward_seq=" + reward_seq + ", order_date="
				+ order_date + ", orderId=" + orderId + ", paymentKey=" + paymentKey + "]";
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPaymentKey() {
		return paymentKey;
	}
	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}
	
}