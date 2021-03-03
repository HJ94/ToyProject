package com.spring.shopping.dto;

import java.sql.Timestamp;

public class Qna {
	private int qseq;
	private String subject;
	private String content;
	private String id;
	private String reply;
	private Timestamp indate;
	private int rep;
	
	public Qna() {
		
	}
	
	public Qna(int qseq, String subject, String content, String id, String reply, Timestamp indate, int rep) {
		this.qseq = qseq;
		this.subject = subject;
		this.content = content;
		this.id = id;
		this.reply = reply;
		this.indate = indate;
		this.rep = rep;
	}
	
	
	public int getQseq() {
		return qseq;
	}
	public void setQseq(int qseq) {
		this.qseq = qseq;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public int getRep() {
		return rep;
	}
	public void setRep(int rep) {
		this.rep = rep;
	}
	
}
