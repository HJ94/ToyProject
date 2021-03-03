package com.spring.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.dao.BoardDao;
import com.spring.shopping.dao.BoardMapper;
import com.spring.shopping.dto.Board;
import com.spring.shopping.util.PagingVO;

@Service
public class BoardService {

	
	@Autowired
	BoardDao boarddao;
	
	BoardMapper mapper;
	
	//중고장터 게시글 select
	public ArrayList<Board> usedmarket(Board board){
		return boarddao.usedmarket(board);
	}
	
	//중고장터 게시글 작성 insert
	public int marketwrite(Board board) {
		return boarddao.marketwrite(board);
	}
	
	//중고장터 게시글 상세보기 select
	public Board usedmarket_detail(String bseq) {
		return boarddao.usedmarket_detail(bseq);
	}
	
	//중고장터 게시글 삭제 delete
	public int usedmarketdelete(String bseq) {
		return boarddao.usedmarketdelete(bseq);
	}
	
	//중고장터 게시글 수정 update
	public int usedmarketupdate(Board board) {
		return boarddao.usedmarketupdate(board);
	
	}
	
	public int countBoard() {
		return boarddao.countBoard();
	}
	
	public List<Board> selectBoard(PagingVO vo){
		return boarddao.selectBoard(vo);
	}

	
}
