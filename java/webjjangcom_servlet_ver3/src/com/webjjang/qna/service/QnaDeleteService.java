package com.webjjang.qna.service;


import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;

public class QnaDeleteService implements Service {
	private QnaDAO dao;
	public QnaDeleteService(QnaDAO dao) {
		this.dao =dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("QnaDeleteService.service()");
		int no = (int) objs[0];
		try {
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		return dao.delete(no);
		// QnaController - QnadeleteService - [QnaDAO]
		} catch(Exception e) {
			e.printStackTrace();
			// 상세한 내용의 예외메시지를 셋팅해서 다시 던지기를 할 수 있다.
			throw new Exception("질문답변 글 삭제  중 오류가 발생되었습니다.");
		}
	}
}