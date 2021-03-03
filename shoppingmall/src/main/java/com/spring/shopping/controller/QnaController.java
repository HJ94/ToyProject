package com.spring.shopping.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shopping.dao.QnaDao;
import com.spring.shopping.dto.Qna;

@Controller
public class QnaController {
	
	@Autowired
	QnaDao qnadao;
	
	@RequestMapping("/qnalist")
	public String qnalist(Qna qna, Model model){
		
		ArrayList<Qna> qnalist = qnadao.qnalist(qna);
		model.addAttribute("qnalist", qnalist);
		
		return "qna";
	}
	
	@RequestMapping("/qnawrite")
	public String qnawrite() {
		return "qnawrite";
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/qnawrites")
	public String qnawrite(Qna qna, Model model) {
		
		int result = qnadao.qnawrite(qna);
		
		return "redirect:qnalist";
	}
	
	//QNA 상세보기
	@RequestMapping(value="/qna_detail", method=RequestMethod.GET)
	public String qnadetail(String qseq, Model model) {
		
		model.addAttribute("qnadetail", qnadao.qnadetail(qseq));
		return "qnadetail";
		
		
	}
	
}
