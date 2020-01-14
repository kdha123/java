/*
 * 질문하기 처리 : QnaWriteService
 * - 답변하기 처리 QnaAnswerService
 */
package com.webjjang.qna.service;


import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaAnswerService implements Service{
	
	private QnaDAO dao;
	public QnaAnswerService(QnaDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao= dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("QnaAnswerService.service()");
		

		try {
			QnaDTO dto = (QnaDTO) objs[0];
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// 관련글 번호가 같으면서 순서번호가 들어온 순서번호보다 크거나 같으면  + 1
		dao.increaseOrdNo(dto);
		// 답변 데이터 처리
		return dao.answer(dto);
		// QnaController - QnaWriteService - [QnaDAO]
		} catch(Exception e) {
			// 상세한 내용의 예외메시지를 셋팅해서 다시 던지기를 할 수 있다.
			throw e;
		}
	}
}
