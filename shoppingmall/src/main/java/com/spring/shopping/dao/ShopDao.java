package com.spring.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.spring.shopping.dto.Cart;
import com.spring.shopping.dto.Product;
import com.spring.shopping.util.Constant;

@Repository
public class ShopDao {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	@Autowired
	SqlSession sqlSession;
	
	public ShopDao() {
		template = Constant.template;
	}
	
	/*
	 * public ArrayList<Product> main(){ String sql =
	 * "select * from product order by kind asc"; return (ArrayList<Product>)
	 * template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
	 * 
	 * }
	 */

	public ArrayList<Product> main(Product product){
		
		ArrayList<Product> result = null;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		
		try {
			result = mapper.mainproduct(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public void join(final String name, final String id,final String pw,final String email,final String phone,final String address) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO MEMBER (name, id, pw, email, phone, address) "
						+ "values (?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				pstmt.setString(3, pw);
				pstmt.setString(4, email);
				pstmt.setString(5, phone);
				pstmt.setString(6, address);
				
				return pstmt;
			}
		});
	
	}
	
	/*
	 * public Product product_detail(String strID) { String sql =
	 * "SELECT * FROM PRODUCT WHERE PSEQ = " + strID; return
	 * template.queryForObject(sql, new
	 * BeanPropertyRowMapper<Product>(Product.class)); }
	 */
	public Product product_detail(String pseq) {
		
		Product product_detail = null;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		
		try {
			product_detail = mapper.product_detail(pseq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product_detail;
	}
	
	
	/* ªıªÛ«∞
	 * public ArrayList<Product> newproduct() { String sql =
	 * "select * from product where kind = " + "'new'"; return
	 * (ArrayList<Product>)template.query(sql, new
	 * BeanPropertyRowMapper<Product>(Product.class)); }
	 */
	
	public ArrayList<Product> newproduct(Product product){
		
		ArrayList<Product> result = null;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);

		try {
			result = mapper.newproduct(product);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	/*
	 * public ArrayList<Product> bestproduct(){ String sql =
	 * "select * from product where kind = " + "'best'"; return (ArrayList<Product>)
	 * template.query(sql, new BeanPropertyRowMapper<Product>(Product.class)); }
	 */
	
	public ArrayList<Product> bestproduct(Product product){
		
		ArrayList<Product> bestproduct = null;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		
		try {
			bestproduct = mapper.bestproduct(product);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bestproduct;
	}
	
	/*
	 * public ArrayList<Product> saleproduct(){ String sql =
	 * "select * from product where kind = " + "'sale'"; return
	 * (ArrayList<Product>)template.query(sql, new
	 * BeanPropertyRowMapper<Product>(Product.class)); }
	 */
	
	public ArrayList<Product> saleproduct(Product product){
		
		ArrayList<Product> saleproduct = null;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		
		try {
			
			saleproduct = mapper.saleproduct(product);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return saleproduct;
		
	}
	
	public int addcart(Cart cart) {
		int addcart = 0;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		
		try {
			addcart = mapper.addcart(cart);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return addcart;
	}
	
	public ArrayList<Cart> showcart(String id) {
		ArrayList<Cart> showcart = null;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		
		try {
			showcart = mapper.showcart(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return showcart;
	}
	
	public int cartdelete(String cseq) {
		int cartdelete = 0;
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		
		try {
			cartdelete = mapper.cartdelete(cseq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cartdelete;
	}
	
}
