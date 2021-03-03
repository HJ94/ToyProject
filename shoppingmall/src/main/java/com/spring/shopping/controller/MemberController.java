package com.spring.shopping.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shopping.dao.MemberDAO;
import com.spring.shopping.dto.Member;

@Controller
public class MemberController {

	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	@RequestMapping("/login_view")
	public String login_view() {
		
		return "login";
	}
	
	//로그인
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String login(Member member ,HttpSession session,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		Member result = dao.loginMember(member);
		
		if(result == null) {
			response.setContentType("text/html; charset=UTF-8");	
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('로그인 정보가 일치하지 않습니다.')");
			out.println("</script>");
			out.flush();			
			return "login";
		}else {
			session.setAttribute("memberId", result.getId());
			return "redirect:main";
		}
	}
	
	
	@RequestMapping("/join_view")
	public String join_view() {
		return "join";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/join")
	public String join(Member member, Model model) {
		
		int result = dao.insertMember(member);
		
		if(result == 0) {
			model.addAttribute("message", "duplicated id");
		}
		 
		return "redirect:main";
	}
	
	//로그아웃
		@RequestMapping("/logout")
		public String logout(HttpSession session ,Member member, Model model) {
			session.invalidate();
			//redirect는 컨트롤러에 재요청 후 jsp로 이동
			return "redirect:main";
		}
	
	//마이페이지 회원 정보 출력
	@RequestMapping("/mypage")
	public String memberinfo(String id, Model model) {
		
		Member memberinfo = dao.memberinfo(id);
		model.addAttribute("memberinfo", memberinfo);
		
		return "mypage";
	}
	
	//마이페이지 회원 정보 수정
	@RequestMapping(value="/memberinfoupdate", method=RequestMethod.POST)
	public String memberinfoupdate(Member member, Model model, String id) {
		
		int memberinfoupdate = dao.memberinfoupdate(member);
		//return "redirect:mypage?id=" + id;
		return "redirect:main";
	}
	
	//마이페이지 회원 탈퇴
	@RequestMapping(value="/memberinfodelete")
	public String memberinfodelete(HttpSession session, String id, Model model) {
		
		int memberinfodelete = dao.memberinfodelete(id);
		session.invalidate();
		return "redirect:main";
	}
	
	@RequestMapping("/IdCheck")
	public String IdCheck() {
		return "IdCheck";
	}
	
	//아이디 중복확인
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)
	public String idcheck(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");	
		PrintWriter out = response.getWriter();
		System.out.println(id);
		String idcheck = dao.idcheck(id);
		if(idcheck == null) {
			out.println("<script language='javascript'>");
			out.println("alert('사용가능한 아이디입니다.')");
			out.println("</script>");
			out.flush();
			return "join";
		}else {
			out.println("<script language='javascript'>");
			out.println("alert('사용중인 아이디입니다.')");
			out.println("</script>");
			out.flush();
			return "IdCheck";
		}	
	}
}
