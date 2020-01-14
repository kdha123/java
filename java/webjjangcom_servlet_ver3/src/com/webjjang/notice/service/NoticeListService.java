package com.webjjang.notice.service;

import java.util.List;

import com.webjjang.main.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.util.page.PageObject;

public class NoticeListService implements Service{
	
	private final NoticeDAO dao;
	// 사용해야할 dao 객체를 초기화 -> 밖에서 생성할 때 넣어준다.
	// Beans에서 한번만 생성해서 생성된 dao를 넣어준다.
	// NoticeListService는 NoticeDAO를 의존(Dependency)한다.
	// 실행되는 것으로는 dao를 변수에 넣어준다.-> 주입(Injection)
	// 위에 2개의 용어 합쳐서 의존성 주입(DI : Dependency Injection)
	public NoticeListService(NoticeDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<NoticeDTO> service(Object[] objs) throws Exception {
		// objs는 파라메터로 받고 있으나 사용하지는 않는다.
		// 데이터 처리 부분에 해당된다.
		PageObject pageObject = (PageObject) objs[0];
		System.out.println("NoticeListService.Service()");
		// 데이터를 오라클에서 가져오기 위해 위에 선언된 DAO객체의 메서드를 호출한다..
		// NoticeController - NoticeListService - [NoticeDAO]
		// 미리 생성하고 여러사람이 같이 쓰더라도 한번만 생성이 될 수 있도록 프로그램한다.
		pageObject.setTotalRow(dao.getTotalRow());
		return dao.list(pageObject);
	}
}
