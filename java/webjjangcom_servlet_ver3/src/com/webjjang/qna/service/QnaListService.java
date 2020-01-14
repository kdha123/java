package com.webjjang.qna.service;

import java.util.List;

import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;
import com.webjjang.util.page.PageObject;

public class QnaListService implements Service{
	private QnaDAO dao;
	public QnaListService(QnaDAO dao) {
		this.dao =dao;
	}
	@Override
	public List<QnaDTO> service(Object[] objs) throws Exception {
		System.out.println("QnaListService.service()");
		
		PageObject pageObject = (PageObject) objs[0];
		pageObject.setTotalRow(dao.getTotalRow());
//		System.out.println("QnaListSerivce.service().pageObject:"+pageObject);
		
		return dao.list(pageObject);

	}
}
