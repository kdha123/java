package com.webjjang.notice.service;

import com.webjjang.main.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.dto.NoticeDTO;

public class NoticeUpdateService implements Service {

	private  NoticeDAO dao;
	// 사용해야할 dao 객체를 초기화 -> 밖에서 생성할 때 넣어준다.
	public NoticeUpdateService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		// 데이터 처리 부분에 해당된다.
		
		System.out.println("NoticeUpdateService.Service()");
		// 데이터를 오라클에서 가져오기 위해 객체를 생성하고 호출한다.
		// BoardController - BoardListService - [BoardDAO]
		try {
			NoticeDTO dto = (NoticeDTO)objs[0];
			return dao.update(dto);
		
		}catch (Exception e) {
			
			throw e;
		}
	}
}
