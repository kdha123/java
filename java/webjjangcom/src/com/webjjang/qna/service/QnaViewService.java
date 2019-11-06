package com.webjjang.qna.service;


import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaViewService {
	public QnaDTO service(int no, int inc) throws Exception {
		System.out.println("QnaViewService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		QnaDAO dao = new QnaDAO();
		// 조회수 1 증가시키는 처리
		if(inc == 1)
			dao.increaseHit(no);
		return dao.view(no);
		
		// QnaController - QnaListService - [QnaDAO]
	}
}
