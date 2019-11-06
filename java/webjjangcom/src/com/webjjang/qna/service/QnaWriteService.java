/*
 * 질문하기 처리 : QnaWriteService
 * - 답변하기 처리 QnaAnswerService
 */
package com.webjjang.qna.service;


import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaWriteService {
	
	public void service(QnaDTO dto) throws Exception {
		System.out.println("QnaWriteService.service()");
		
		try {
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		QnaDAO dao = new QnaDAO();
		dao.write(dto);
		// QnaController - QnaWriteService - [QnaDAO]
		} catch(Exception e) {
			// 상세한 내용의 예외메시지를 셋팅해서 다시 던지기를 할 수 있다.
			throw e;
		}
	}
}
