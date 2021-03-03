package com.spring.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.dao.MemberDAO;
import com.spring.shopping.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberdao;
	
	public int insertMember(Member member) {
		return memberdao.insertMember(member);
	}
	
	public Member loginMember(Member member) {
		return memberdao.loginMember(member);
	}
	
	public Member memberinfo(String id) {
		return memberdao.memberinfo(id);
	}
	
	public int memberinfoupdate(Member member) {
		return memberdao.memberinfoupdate(member);
	}
	
	public int memberinfodelete(String id) {
		return memberdao.memberinfodelete(id);
	}
	public String idcheck(String id) {
		return memberdao.idcheck(id);
	}

}
