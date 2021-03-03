package com.spring.shopping.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.shopping.dao.BoardDao;
import com.spring.shopping.dto.Board;
import com.spring.shopping.service.BoardService;
import com.spring.shopping.util.PagingVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardDao boarddao;
	@Autowired
	BoardService boardservice;
	
	@RequestMapping("/usedmarket")
	public String usedmarket(Board board, Model model) {
		
		ArrayList<Board> usedmarket = boarddao.usedmarket(board);
		model.addAttribute("usedmarket", usedmarket);
		
		return "redirect:usedmarketpage";
	}
	
	@RequestMapping("/usedmarketwrite")
	public String usedmarket() {
		
		return "usedmarketwrite";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/marketwrite")
	public String marketwrite(Board board, Model model) {
		
		int result = boarddao.marketwrite(board);
		
		
		return "redirect:boardList";
		
	}
	
	/*
	 * @RequestMapping("/usedmarketdetail") public String usedmarketdetail() {
	 * return "usedmarketdetail"; }
	 */
	
	//중고장터 상세보기 
	@RequestMapping(value="/usedmarket_detail", method=RequestMethod.GET)
	public String usedmarket_detail(String bseq, Model model) {
		
		
		model.addAttribute("usedmarket_detail", boarddao.usedmarket_detail(bseq));
		
		return "usedmarketdetail";
			
	}
	
	@RequestMapping(value="/usedmarketdelete", method=RequestMethod.POST)
	public String usedmarketdelete(String bseq, Model model) {
		
		int usedmarketdelete = boarddao.usedmarketdelete(bseq);
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/usedmarket_update", method=RequestMethod.POST)
	public String usedmarketupdateview(String bseq, Model model) {
		
		model.addAttribute("usedmarket_detail", boarddao.usedmarket_detail(bseq));
		return "usedmarketupdate";
	}
	
	@RequestMapping(value="/usedmarketupdate", method= {RequestMethod.POST, RequestMethod.GET})
	public String usedmarketupdate(Board board, Model model) {
		
		int usedmarketupdate = boarddao.usedmarketupdate(board);
		return "redirect:boardList";
	}
	
	
	@RequestMapping("/boardList")
	public String boardList(PagingVO vo, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		
		int total = boardservice.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", boardservice.selectBoard(vo));
		
		return "usedmarketpage";
	}
	

	
}
