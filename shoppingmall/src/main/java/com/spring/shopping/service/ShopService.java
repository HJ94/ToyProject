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
	
	//���������� �� ��ǰ select
	public ArrayList<Product> main(Product product){
		return shopdao.main(product);
	}
	
	//�Ż�ǰ select
	public ArrayList<Product> newproduct(Product product){
		return shopdao.newproduct(product);
	}
	
	//����Ʈ ��ǰ select
	public ArrayList<Product> bestproduct(Product product){
		return shopdao.bestproduct(product);
	}
	
	//���� ��ǰ select
	public ArrayList<Product> saleproduct(Product product){
		return shopdao.saleproduct(product);
	}
	
	//��ٱ��� ��� insert
	public int addcart(Cart cart) {
		return shopdao.addcart(cart);
	}
	
	//��ٱ��� �ҷ����� select
	public ArrayList<Cart> showcart(String id){
		return shopdao.showcart(id);
	}
	
	public Product product_detail(String pseq) {
		return shopdao.product_detail(pseq);
	}
	
	//��ٱ��� ���� delete
	public int cartdelete(String cseq) {
		return shopdao.cartdelete(cseq);
	}
	
}
