package com.webjjang.qna.service;

import java.util.List;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaListService {
	
	public List<QnaDTO> service() throws Exception {
		System.out.println("QnaListService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		QnaDAO dao = new QnaDAO();
		return dao.list();
		// QnaController - QnaListService - [QnaDAO]
	}
}
