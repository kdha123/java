package com.webjjang.board.service;


import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardViewService {

	// 데이터는 Controller <-> DAO
	// 글번호를 COntroller 에서 받아서 처리한다.
	public BoardDTO service(int no) throws Exception {
		// 데이터 처리부분에 해당된다.
		
		System.out.println("BoardViewService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		BoardDAO dao = new BoardDAO();
		return dao.view(no);
		// BoardController - BoardViewService - [BoardDAO]
			}
}
