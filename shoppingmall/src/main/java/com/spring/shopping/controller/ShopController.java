package com.spring.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.spring.shopping.command.ShopCommand;
import com.spring.shopping.dao.MemberDAO;
import com.spring.shopping.dao.ShopDao;
import com.spring.shopping.dto.Cart;
import com.spring.shopping.dto.Member;
import com.spring.shopping.dto.Product;
import com.spring.shopping.util.Constant;

@Controller
public class ShopController {

	
	public JdbcTemplate template;
	//ShopCommand command;
	@Autowired
	MemberDAO dao;

	@Autowired
	ShopDao shopdao;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//메인 페이지
	@RequestMapping("/main")
	public String main(Product product, Model model) {
		
		ArrayList<Product> mainproduct = shopdao.main(product);
		model.addAttribute("mainproduct", mainproduct);
		
		return "mainpage";
	}
	/*
	 * //메인 페이지
	 * 
	 * @RequestMapping("/main") public String main(Model model) {
	 * 
	 * command = new ShopMainCommand(); command.execute(model);
	 * 
	 * return "mainpage"; }
	 */
	
	//상품 상세보기 페이지
	@RequestMapping("/product_detail")
	public String product_detail(String pseq, Model model) {
		
		Product product_detail = shopdao.product_detail(pseq);
		model.addAttribute("product_detail", product_detail);
		return "productdetail";
	}
	
	
	
	/*
	 * @RequestMapping("/join_view") public String join_view() { return "join";
	 * 
	 * }
	 * 
	 * @RequestMapping(method=RequestMethod.POST, value = "/join") public String
	 * join(Member member, Model model) {
	 * 
	 * int result = dao.insertMember(member);
	 * 
	 * if(result == 0) { model.addAttribute("message", "duplicated id"); }
	 * 
	 * return "redirect:main"; }
	 */
	
	/*
	 * @RequestMapping("/newproduct") public String newprodcut(HttpServletRequest
	 * request, Model model) {
	 * 
	 * command = new ShopNewProductCommand(); command.execute(model);
	 * 
	 * return "newproduct"; }
	 */
	
	@RequestMapping("/newproduct")
	public String newprodcut(Product product, Model model) {
		
		ArrayList<Product> newproduct = shopdao.newproduct(product);
		model.addAttribute("newproduct", newproduct);
		
		return "newproduct";
	}
	
	@RequestMapping("/bestproduct")
	public String bestproduct(Product product, Model model) {
		
		ArrayList<Product> bestproduct = shopdao.bestproduct(product);
		model.addAttribute("bestproduct", bestproduct);
		
		return "bestproduct";
	}
	
	@RequestMapping("/saleproduct")
	public String saleproduct(Product product, Model model) {
		
		ArrayList<Product> saleproduct = shopdao.saleproduct(product);
		model.addAttribute("saleproduct", saleproduct);
		
		return "saleproduct";
	}
	
	//장바구니 담기
	@RequestMapping(value="/addcart", method=RequestMethod.POST)
	public String addcart(Cart cart, Model model, String id) {
		int result = shopdao.addcart(cart);
		
		
		return "redirect:showcart?id=" + id;
	}
	
	//장바구니 보기
	@RequestMapping("/showcart")
	public String showcart(String id, Model model) {
		ArrayList<Cart> showcart = shopdao.showcart(id);
		model.addAttribute("showcart", showcart);
		
		return "cart";
	}
	
	//장바구니 삭제
	
	 @RequestMapping(value="/cartdelete") 
	 public String cartdelete(String id,String cseq, Model model) { 
	 int cartdelete = shopdao.cartdelete(cseq);
	  
	return "redirect:showcart?id=" + id;
 
}
	 
	
	
}
