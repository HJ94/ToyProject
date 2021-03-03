package com.spring.shopping.dao;

import java.util.ArrayList;

import com.spring.shopping.dto.Admin;
import com.spring.shopping.dto.Member;
import com.spring.shopping.dto.Product;
import com.spring.shopping.dto.Qna;

public interface AdminMapper {
	
	public ArrayList<Member> memberlist(Member member);
	public ArrayList<Product> productlist(Product product);
	public ArrayList<Qna> qnalist(Qna qna);
	public int adminqna_reply_answer(Qna qna);
	public int adminmemberdelete(String mseq);
	public Admin adminlogin(Admin admin);

}
