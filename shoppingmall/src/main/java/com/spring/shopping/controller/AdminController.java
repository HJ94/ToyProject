package com.spring.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shopping.dao.AdminDao;
import com.spring.shopping.dao.QnaDao;
import com.spring.shopping.dto.Admin;
import com.spring.shopping.dto.Member;
import com.spring.shopping.dto.Product;
import com.spring.shopping.dto.Qna;

@Controller
public class AdminController {

	@Autowired
	AdminDao admindao;
	@Autowired
	QnaDao qnadao;
	
	@RequestMapping("/memberlist")
	public String memberlist(Member member, Model model) {
		
		ArrayList<Member> memberlist = admindao.memberlist(member); 
		model.addAttribute("memberlist", memberlist);
		
		return "adminmain";
	}
	
	@RequestMapping("/adminmemberdelete")
	public String adminmemberdelete(String mseq, Model model) {
		
		int adminmemberdelete = admindao.adminmemberdelete(mseq);
		return "redirect:adminmain";
	}
	
	@RequestMapping("/productlist")
	public String productlist(Product product, Model model) {
		
		ArrayList<Product> productlist = admindao.productlist(product);
		model.addAttribute("productlist", productlist);
		
		return "adminshop";
	}
	
	@RequestMapping("/adminqnalist")
	public String qnalist(Qna qna, Model model) {
		
		ArrayList<Qna> qnalist = admindao.qnalist(qna);
		model.addAttribute("qnalist", qnalist);
		
		return "adminqna";
	}
	
	@RequestMapping(value="/adminqna_reply", method=RequestMethod.GET)
	public String adminqna_reply(String qseq, Model model) {
		

		model.addAttribute("member_qna", qnadao.qnadetail(qseq));
		
		return "adminqnareply";
	}
	
	@RequestMapping(value="/adminqna_reply_answer", method=RequestMethod.POST)
	public String adminqna_reply_answer(Qna qna, Model model) {
		
		int adminqna_reply_answer = admindao.adminqna_reply_answer(qna);
		
		return "redirect:adminqnalist";
	}
	
	@RequestMapping("/admin_login")
	public String admin_login() {
		return "adminlogin";
	}

	@RequestMapping(value="/adminlogin")
	public String adminlogin(Member member, Admin admin, HttpSession session, Model model) {
		
		Admin adminlogin = admindao.adminlogin(admin);
		
		if(adminlogin == null) {
			model.addAttribute("message", "정보 일치하지 않음");
			return "adminlogin";
		}else {
			ArrayList<Member> memberlist = admindao.memberlist(member); 
			model.addAttribute("memberlist", memberlist);
			session.setAttribute("adminId", adminlogin.getId());
			return "adminmain";
		}
	}
	
	@RequestMapping(value="/product_register")
	public String product_register() {
		return "productregister";
	}

}
