package com.spring.shopping.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.dao.QnaDao;
import com.spring.shopping.dto.Qna;

@Service
public class QnaService {
	
	@Autowired
	QnaDao qnadao;
	
	//Q&A 리스트 출력 select
	public ArrayList<Qna> qnalist(Qna qna){
		return qnadao.qnalist(qna);
	}
	
	//Q&A 작성 insert
	public int qnawrite(Qna qna) {
		return qnadao.qnawrite(qna);
	}
	
	//Q&A 상세보기 select
	public Qna qnadetail(String qseq) {
		return qnadao.qnadetail(qseq);
	}
	
	
	
}
