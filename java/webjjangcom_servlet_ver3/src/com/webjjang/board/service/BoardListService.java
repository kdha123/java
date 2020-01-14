package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class BoardListService implements Service {

	private BoardDAO dao;
	
	public BoardListService(BoardDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<BoardDTO> service(Object[] objs) throws Exception {
		// 데이터 변환
		PageObject pageObject = (PageObject) objs[0];
		
		// 데이터 처리부분에 해당된다.
		
		System.out.println("BoardListService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardListService - [BoardDAO]
		// 전체 데이터의 갯수를 구해서 pageObject에 넣는다. -> 전체 페이지가 자동으로 구해진다.
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("BoardListService.service().pageObject:" + pageObject);
		
		
		return dao.list(pageObject);
			}
}
