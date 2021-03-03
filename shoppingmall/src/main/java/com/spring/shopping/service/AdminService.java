package com.spring.shopping.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.dao.AdminDao;
import com.spring.shopping.dao.AdminMapper;
import com.spring.shopping.dto.Admin;
import com.spring.shopping.dto.Member;
import com.spring.shopping.dto.Product;
import com.spring.shopping.dto.Qna;

@Service
public class AdminService implements AdminMapper{

	
	@Autowired
	AdminDao admindao;
	
	//������ ȸ�� ��� ��� select
	public ArrayList<Member> memberlist(Member member){
		return admindao.memberlist(member);
	}
	
	//������ ��ǰ ��� ��� select
	public ArrayList<Product> productlist(Product product){
		return admindao.productlist(product);
	}
	
	//������ Q&A ��� ��� select
	public ArrayList<Qna> qnalist(Qna qna){
		return admindao.qnalist(qna);
	}
	
	//������ Q&A �亯 insert
	public int adminqna_reply_answer(Qna qna) {
		return admindao.adminqna_reply_answer(qna);
	}
	
	//������ ȸ�� ���� delete
	public int adminmemberdelete(String mseq) {
		return admindao.adminmemberdelete(mseq);
	}
	
	//������ �α���
	public Admin adminlogin(Admin admin) {
		return admindao.adminlogin(admin);
	}
}
