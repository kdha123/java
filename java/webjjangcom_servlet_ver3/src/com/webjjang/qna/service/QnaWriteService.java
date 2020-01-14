/*
 * 질문하기 처리 : QnaWriteService
 * - 답변하기 처리 QnaAnswerService
 */
package com.webjjang.qna.service;


import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaWriteService implements Service{
	private QnaDAO dao;
	public QnaWriteService(QnaDAO dao) {
		this.dao =dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("QnaWriteService.service()");
		QnaDTO dto = (QnaDTO) objs[0];
		try {
			
		return dao.write(dto);
		
		} catch(Exception e) {
			// 상세한 내용의 예외메시지를 셋팅해서 다시 던지기를 할 수 있다.
			throw e;
		}
	}
}
