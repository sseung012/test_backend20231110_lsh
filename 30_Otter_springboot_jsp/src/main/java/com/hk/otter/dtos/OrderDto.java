package com.hk.otter.dtos;

public class OrderDto {

   public int seq;
   public String user_id;
   public String user_name;
   public String title;
   public String select_reward;
   public int select_amount;
   public String address1;
   public String address2;
   public String address3;
   public String phone; 
   public int total_price;
   public int reward_seq;
   public String order_date;
   public String getOrder_date() {
      return order_date;
   }
   public void setOrder_date(String order_date) {
      this.order_date = order_date;
   }
   public String orderId;
   public String paymentKey;
   
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDto(int seq, String user_id, String user_name, String title, String select_reward, int select_amount,
			String address1, String address2, String address3, String phone, int total_price, int reward_seq,
			String order_date, String orderId, String paymentKey) {
		super();
		this.seq = seq;
		this.user_id = user_id;
		this.user_name = user_name;
		this.title = title;
		this.select_reward = select_reward;
		this.select_amount = select_amount;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.phone = phone;
		this.total_price = total_price;
		this.reward_seq = reward_seq;
		this.order_date = order_date;
		this.orderId = orderId;
		this.paymentKey = paymentKey;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
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
	@Override
	public String toString() {
		return "OrderDto [seq=" + seq + ", user_id=" + user_id + ", user_name=" + user_name + ", title=" + title
				+ ", select_reward=" + select_reward + ", select_amount=" + select_amount + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + ", phone=" + phone + ", total_price="
				+ total_price + ", reward_seq=" + reward_seq + ", order_date=" + order_date + ", orderId=" + orderId
				+ ", paymentKey=" + paymentKey + "]";
	}
	
}