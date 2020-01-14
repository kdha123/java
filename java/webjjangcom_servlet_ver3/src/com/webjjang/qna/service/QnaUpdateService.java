package com.webjjang.qna.service;


import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaUpdateService implements Service{
	private QnaDAO dao;
	public QnaUpdateService(QnaDAO dao) {
		this.dao =dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("QnaUpdateService.service()");
		
		QnaDTO dto = (QnaDTO) objs[0];
		try {
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		return dao.update(dto);
		// QnaController - QnaUpdateService - [QnaDAO]
		} catch(Exception e) {
			// 상세한 내용의 예외메시지를 셋팅해서 다시 던지기를 할 수 있다.
			// 개발자를 위한 예외처리
			e.printStackTrace();
			// 사용자를 위한 예외처리
			 throw new Exception("질문답변 수정 중 오류가 발생되었습니다.");
//			throw e;
		}
	}
}
