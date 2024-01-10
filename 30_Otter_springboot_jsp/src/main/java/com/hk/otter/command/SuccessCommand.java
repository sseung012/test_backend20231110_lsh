package com.hk.otter.command;

public class SuccessCommand {
	
	private int Seq;

	private String User_id;
	
	private String User_name;
	
	private String Title;
	
	private String Select_reward;
	
	private int Select_amount;
	
	private String Address;
	
	private String Phone;
	
	private int Total_price;

	private int Reward_seq;
	
	private String Order_date;
	
	private String orderId;
	
	private String paymentKey;
	
	
	public SuccessCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getSeq() {
		return Seq;
	}

	public void setSeq(int seq) {
		Seq = seq;
	}
	
	public String getUser_id() {
		return User_id;
	}


	public void setUser_id(String user_id) {
		User_id = user_id;
	}


	public String getUser_name() {
		return User_name;
	}


	public void setUser_name(String user_name) {
		User_name = user_name;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getSelect_reward() {
		return Select_reward;
	}


	public void setSelect_reward(String select_reward) {
		Select_reward = select_reward;
	}


	public int getSelect_amount() {
		return Select_amount;
	}


	public void setSelect_amount(int select_amount) {
		Select_amount = select_amount;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public int getTotal_price() {
		return Total_price;
	}


	public void setTotal_price(int total_price) {
		Total_price = total_price;
	}


	public int getReward_seq() {
		return Reward_seq;
	}


	public void setReward_seq(int reward_seq) {
		Reward_seq = reward_seq;
	}


	public String getOrder_date() {
		return Order_date;
	}


	public void setOrder_date(String order_date) {
		Order_date = order_date;
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




	public SuccessCommand(int seq, String user_id, String user_name, String title, String select_reward,
			int select_amount, String address, String phone, int total_price, int reward_seq, String order_date) {
		super();
		Seq = seq;
		User_id = user_id;
		User_name = user_name;
		Title = title;
		Select_reward = select_reward;
		Select_amount = select_amount;
		Address = address;
		Phone = phone;
		Total_price = total_price;
		Reward_seq = reward_seq;
		Order_date = order_date;
	}

	
	public SuccessCommand(int seq, String user_id, String user_name, String title, String select_reward, int select_amount,
			String address, String phone, int total_price, int reward_seq) {
		super();
		Seq=seq;
		User_id = user_id;
		User_name = user_name;
		Title = title;
		Select_reward = select_reward;
		Select_amount = select_amount;
		Address = address;
		Phone = phone;
		Total_price = total_price;
		Reward_seq = reward_seq;
	}

	
	public SuccessCommand(String orderId, String paymentKey) {
		super();
		this.orderId = orderId;
		this.paymentKey = paymentKey;
	}

	@Override
	public String toString() {
		return "SuccessCommand [Seq=" + Seq + ", User_id=" + User_id + ", User_name=" + User_name + ", Title=" + Title
				+ ", Select_reward=" + Select_reward + ", Select_amount=" + Select_amount + ", Address=" + Address
				+ ", Phone=" + Phone + ", Total_price=" + Total_price + ", Reward_seq=" + Reward_seq + ", Order_date="
				+ Order_date + ", orderId=" + orderId + ", paymentKey=" + paymentKey + "]";
	}

	

	



	


}
