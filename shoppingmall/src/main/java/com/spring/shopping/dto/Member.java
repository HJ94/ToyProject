package com.spring.shopping.dto;

public class Member {
	
	private int mseq;
	private String name;
	private String id;
	private String pw;
	private String email;
	private String phone;
	private String address;
	
	public Member() {
		
	}
	
	
	public Member(int mseq ,String name, String id, String pw, String email, String phone, String address) {
		super();
		this.mseq = mseq;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public int getMseq() {
		return mseq;
	}


	public void setMseq(int mseq) {
		this.mseq = mseq;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
