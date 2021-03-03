package com.spring.shopping.dto;

import java.sql.Timestamp;

public class Board {
	private int bseq;
	private String subject;
	private String content;
	private String id;
	private Timestamp indate;
	private int hit;
	
	public Board() {
		
	}
	
	public Board(int bseq, String subject, String content, String id, Timestamp indate, int hit) {
		this.bseq = bseq;
		this.subject = subject;
		this.content = content;
		this.id = id;
		this.indate = indate;
		this.hit = hit;
	}
	
	
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
