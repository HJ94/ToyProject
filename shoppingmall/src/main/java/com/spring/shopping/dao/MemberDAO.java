package com.spring.shopping.dao;

import java.io.PrintWriter;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shopping.dto.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertMember(Member member) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.insertMember(member);
		}catch(Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public String idcheck(String id) {
		String idcheck = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			idcheck = mapper.idcheck(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return idcheck;
		
	}
	
	
	
	public Member loginMember(Member member) {
		
		Member result = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.loginMember(member);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Member memberinfo(String id) {
		
		Member memberinfo = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			memberinfo = mapper.memberinfo(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberinfo;
	}
	
	public int memberinfoupdate(Member member) {
		
		int memberinfoupdate = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			memberinfoupdate = mapper.memberinfoupdate(member);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return memberinfoupdate;
	}
	
	public int memberinfodelete(String id) {
		
		int memberinfodelete = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			memberinfodelete = mapper.memberinfodelete(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberinfodelete;
	}
	
}
