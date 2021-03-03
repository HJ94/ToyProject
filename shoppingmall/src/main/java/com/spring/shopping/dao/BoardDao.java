package com.spring.shopping.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shopping.dto.Board;
import com.spring.shopping.util.PagingVO;

@Repository
public class BoardDao {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public ArrayList<Board> usedmarket(Board board){
		
		ArrayList<Board> usedmarket = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			usedmarket = mapper.usedmarket(board);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usedmarket;
	}
	
//	public void upHit(String bseq) {
//		
//		int upHit  = 0;
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
//		try {
//			upHit = mapper.upHit(bseq);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}	
//	}
//	
	
	public int marketwrite(Board board) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			result = mapper.marketwrite(board);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public Board usedmarket_detail(String bseq) {
		Board usedmarket_detail = null;
		int upHit = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			usedmarket_detail = mapper.usedmarket_detail(bseq);
			upHit = mapper.upHit(bseq);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usedmarket_detail;
		
	}
	
	public int usedmarketdelete(String bseq) {
		int usedmarketdelete = 0;
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
		try {
			usedmarketdelete = mapper.usedmarketdelete(bseq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return usedmarketdelete;
	
	}
	
	public int usedmarketupdate(Board board) {
		int usedmarketupdate = 0;
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			usedmarketupdate = mapper.usedmarketupdate(board);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usedmarketupdate;
	}
	
	public int countBoard() {
		int countBoard = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			countBoard = mapper.countBoard();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return countBoard;
	}
	
	public List<Board> selectBoard(PagingVO vo){
		
		List<Board> selectBoard = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			selectBoard = mapper.selectBoard(vo);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return selectBoard;
	}

}	
 