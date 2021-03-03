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
	
	//관리자 회원 목록 출력 select
	public ArrayList<Member> memberlist(Member member){
		return admindao.memberlist(member);
	}
	
	//관리자 상품 목록 출력 select
	public ArrayList<Product> productlist(Product product){
		return admindao.productlist(product);
	}
	
	//관리자 Q&A 목록 출력 select
	public ArrayList<Qna> qnalist(Qna qna){
		return admindao.qnalist(qna);
	}
	
	//관리자 Q&A 답변 insert
	public int adminqna_reply_answer(Qna qna) {
		return admindao.adminqna_reply_answer(qna);
	}
	
	//관리자 회원 삭제 delete
	public int adminmemberdelete(String mseq) {
		return admindao.adminmemberdelete(mseq);
	}
	
	//관리자 로그인
	public Admin adminlogin(Admin admin) {
		return admindao.adminlogin(admin);
	}
}
