package com.spring.shopping.dao;

import java.util.ArrayList;

import com.spring.shopping.dto.Qna;

public interface QnaMapper {
	
	public ArrayList<Qna> qnalist(Qna qna);
	public int qnawrite(Qna qna);
	public Qna qnadetail(String qna);
}
