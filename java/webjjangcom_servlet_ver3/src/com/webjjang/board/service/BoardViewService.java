package com.webjjang.board.service;


import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardViewService implements Service {

	private BoardDAO dao;
	public BoardViewService(BoardDAO dao) {
		this.dao = dao;
	}
	// 데이터는 Controller <-> DAO
	// 글번호를 COntroller 에서 받아서 처리한다.
	@Override
	public BoardDTO service(Object[] objs) throws Exception {
		// 데이터 처리부분에 해당된다.
		
		System.out.println("BoardViewService.service()");
		int no = (int) objs[0];
		int cnt = (int) objs[1];
				
		// 데이터를 오라클에서 가져오기 위해서 Beans에서 생성한 객체를 호출한다.
		if(cnt == 1)
			dao.increaseHit(no);
		return dao.view(no);
		// BoardController - BoardViewService - [BoardDAO]
			}
}
