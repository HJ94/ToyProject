package com.spring.shopping.dao;

import java.util.ArrayList;

import com.spring.shopping.dto.Cart;
import com.spring.shopping.dto.Product;

public interface ShopMapper {
		
	public ArrayList<Product> mainproduct(Product product);
	public ArrayList<Product> newproduct(Product product);
	public ArrayList<Product> bestproduct(Product product);
	public ArrayList<Product> saleproduct(Product product);
	public int addcart(Cart cart);
	public ArrayList<Cart> showcart(String id);
	public Product product_detail(String pseq);
	public int cartdelete(String cseq);
}
