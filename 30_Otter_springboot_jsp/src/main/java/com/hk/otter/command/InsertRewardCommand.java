package com.hk.otter.command;

import jakarta.validation.constraints.NotBlank;

public class InsertRewardCommand {
	
	private int seq;
	
	@NotBlank(message = "리워드 제목을 입력하세요!")
	private String reward_name;
	
	@NotBlank(message = "리워드 가격을 입력하세요!")
	private int price;
	
	@NotBlank(message = "리워드 설명을 입력하세요!")
	private String combination;
	
	@NotBlank(message = "리워드 수량을 입력하세요!")
	private int stock;
	
	private int product_seq;
	
	private int sold_stock;

	public InsertRewardCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsertRewardCommand(int seq, @NotBlank(message = "리워드 제목을 입력하세요!") String reward_name,
			@NotBlank(message = "리워드 가격을 입력하세요!") int price, @NotBlank(message = "리워드 설명을 입력하세요!") String combination,
			@NotBlank(message = "리워드 수량을 입력하세요!") int stock, int product_seq, int sold_stock) {
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
		return "InsertRewardCommand [seq=" + seq + ", reward_name=" + reward_name + ", price=" + price
				+ ", combination=" + combination + ", stock=" + stock + ", product_seq=" + product_seq + ", sold_stock="
				+ sold_stock + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
