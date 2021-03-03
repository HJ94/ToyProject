package com.spring.shopping.dto;

import java.sql.Timestamp;

public class Product {
	
	private int pseq;
	private String name;
	private String kind;
	private int price;
	private String content;
	private String image;
	private String useyn;
	private String bestyn;
	private Timestamp indate;
	
	public Product() {}
	
	public Product(int pseq, String name, String kind, int price, String content, String image, String useyn, String bestyn, Timestamp indate) {
		this.pseq = pseq;
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.content = content;
		this.image = image;
		this.useyn = useyn;
		this.bestyn = bestyn;
		this.indate = indate;
	}
	
	
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getBestyn() {
		return bestyn;
	}
	public void setBestyn(String bestyn) {
		this.bestyn = bestyn;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
}
