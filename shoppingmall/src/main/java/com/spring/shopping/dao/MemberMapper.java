package com.spring.shopping.dao;

import com.spring.shopping.dto.Member;

public interface MemberMapper {
	public int insertMember(Member member);
	public Member loginMember(Member member);
	public Member memberinfo(String id);
	public int memberinfoupdate(Member member);
	public int memberinfodelete(String id);
	public String idcheck(String id);
}
