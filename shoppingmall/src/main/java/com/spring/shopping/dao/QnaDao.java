package com.spring.shopping.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shopping.dto.Qna;

@Repository
public class QnaDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public ArrayList<Qna> qnalist(Qna qna){
		
		ArrayList<Qna> qnalist = null;
		QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
		
		try {
			qnalist = mapper.qnalist(qna);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qnalist;
		
	}
	
	public int qnawrite(Qna qna) {
		
		int qnawrite = 0;
		QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
		
		try {
			qnawrite = mapper.qnawrite(qna);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qnawrite;
		
	}
	
	public Qna qnadetail(String qseq) {
		
		Qna qnadetail = null;
		QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
		
		try {
			qnadetail = mapper.qnadetail(qseq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qnadetail;
	}
}
