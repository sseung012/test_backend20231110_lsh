package com.hk.otter.dtos;

public class RewardDto {

	private int seq;
	private String reward_name;
	private int price;
	private String combination;
	private int stock;
	private int product_seq;
	private int sold_stock;
	private int total_price;
	
	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public RewardDto() {
		super();
	}
	
	public RewardDto(String reward_name, int price, String combination, int stock, int product_seq) {
		super();
		this.reward_name = reward_name;
		this.price = price;
		this.combination = combination;
		this.stock = stock;
		this.product_seq = product_seq;
	}

	
	//리워드 선택한거 불러오기
	public RewardDto(int seq, String reward_name, int price, int stock, int total_price) {
		super();
		this.seq = seq;
		this.reward_name = reward_name;
		this.price = price;
		this.stock = stock;
		this.total_price = total_price;
	}
	
	public RewardDto(int seq, String reward_name, int price, String combination, int stock, int product_seq,
			int sold_stock) {
		super();
		this.seq = seq;
		this.reward_name = reward_name;
		this.price = price;
		this.combination = combination;
		this.stock = stock;
		this.product_seq = product_seq;
		this.sold_stock = sold_stock;
	}


	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getReward_name() {
		return reward_name;
	}

	public void setReward_name(String reward_name) {
		this.reward_name = reward_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCombination() {
		return combination;
	}

	public void setCombination(String combination) {
		this.combination = combination;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getProduct_seq() {
		return product_seq;
	}

	public void setProduct_seq(int product_seq) {
		this.product_seq = product_seq;
	}

	public int getSold_stock() {
		return sold_stock;
	}

	public void setSold_stock(int sold_stock) {
		this.sold_stock = sold_stock;
	}

	@Override
	public String toString() {
		return "RewardDto [seq=" + seq + ", reward_name=" + reward_name + ", price=" + price + ", combination="
				+ combination + ", stock=" + stock + ", product_seq=" + product_seq + ", sold_stock=" + sold_stock
				+ "]";
	}
	
}
