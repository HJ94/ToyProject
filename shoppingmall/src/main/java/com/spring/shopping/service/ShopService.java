package com.spring.shopping.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.dao.ShopDao;
import com.spring.shopping.dto.Cart;
import com.spring.shopping.dto.Product;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopdao;
	
	//메인페이지 전 상품 select
	public ArrayList<Product> main(Product product){
		return shopdao.main(product);
	}
	
	//신상품 select
	public ArrayList<Product> newproduct(Product product){
		return shopdao.newproduct(product);
	}
	
	//베스트 상품 select
	public ArrayList<Product> bestproduct(Product product){
		return shopdao.bestproduct(product);
	}
	
	//세일 상품 select
	public ArrayList<Product> saleproduct(Product product){
		return shopdao.saleproduct(product);
	}
	
	//장바구니 담기 insert
	public int addcart(Cart cart) {
		return shopdao.addcart(cart);
	}
	
	//장바구니 불러오기 select
	public ArrayList<Cart> showcart(String id){
		return shopdao.showcart(id);
	}
	
	public Product product_detail(String pseq) {
		return shopdao.product_detail(pseq);
	}
	
	//장바구니 삭제 delete
	public int cartdelete(String cseq) {
		return shopdao.cartdelete(cseq);
	}
	
}
