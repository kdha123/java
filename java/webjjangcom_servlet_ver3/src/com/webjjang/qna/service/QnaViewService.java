package com.webjjang.qna.service;


import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;

public class QnaViewService implements Service{
	private QnaDAO dao;
	public QnaViewService(QnaDAO dao) {
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("QnaViewService.service()");
		// 데이터 전환
		
		int no = (int)objs[0];
		int inc = (int)objs[1];
		// 조회수 1 증가시키는 처리
		if(inc == 1)
			dao.increaseHit(no);
		return dao.view(no);
		
		// QnaController - QnaListService - [QnaDAO]
	}
}
