package com.spring.shopping.dto;

import java.sql.Timestamp;

public class Cart {
	
	private String cseq;
	private String id;
	private String name;
	private int price;
	private Timestamp indate;
	private String image;
	
	public Cart() {
		
	}
	public Cart(String cseq, String id, String name, int price, Timestamp indate, String image) {
		this.cseq = cseq;
		this.id = id;
		this.name = name;
		this.price = price;
		this.indate = indate;
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
	
}
