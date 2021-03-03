package com.spring.shopping.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shopping.dto.Admin;
import com.spring.shopping.dto.Member;
import com.spring.shopping.dto.Product;
import com.spring.shopping.dto.Qna;

@Repository
public class AdminDao {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public ArrayList<Member> memberlist(Member member){
		
		ArrayList<Member> memberlist = null;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		
		try {
			memberlist = mapper.memberlist(member);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberlist;
	}
	
	public ArrayList<Product> productlist(Product product){
		
		ArrayList<Product> productlist = null;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		
		try {
			productlist = mapper.productlist(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}
	
	public ArrayList<Qna> qnalist(Qna qna){
		
		ArrayList<Qna> qnalist = null;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		
		try {
			qnalist = mapper.qnalist(qna);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qnalist;
	}
	
	public int adminqna_reply_answer(Qna qna) {
		
		int adminqna_reply_answer = 0;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		
		try {
			adminqna_reply_answer = mapper.adminqna_reply_answer(qna);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return adminqna_reply_answer;
	}
	
	public int adminmemberdelete(String mseq) {
		
		int adminmemberdelete = 0;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		
		try {
			adminmemberdelete = mapper.adminmemberdelete(mseq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return adminmemberdelete;
	}
	
	public Admin adminlogin(Admin admin) {
		
		Admin adminlogin = null;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		
		try {
			adminlogin = mapper.adminlogin(admin);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return adminlogin;
	}
}
