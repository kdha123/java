package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> service() throws Exception {
		// 데이터 처리부분에 해당된다.
		
		System.out.println("BoardListService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		BoardDAO dao = new BoardDAO();
		return dao.list();
		// BoardController - BoardListService - [BoardDAO]
			}
}
