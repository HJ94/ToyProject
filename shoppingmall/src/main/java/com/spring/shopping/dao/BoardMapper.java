package com.spring.shopping.dao;

import java.util.ArrayList;
import java.util.List;

import com.spring.shopping.dto.Board;
import com.spring.shopping.util.PagingVO;

public interface BoardMapper {
	
	public ArrayList<Board> usedmarket(Board board);
	public int marketwrite(Board board);
	public Board usedmarket_detail(String bseq);
	public int usedmarketdelete(String bseq);
	public int usedmarketupdate(Board board);
	public int countBoard();
	public List<Board> selectBoard(PagingVO vo);
	public int upHit(String bseq);
}
