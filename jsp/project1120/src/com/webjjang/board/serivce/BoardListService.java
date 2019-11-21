package com.webjjang.board.serivce;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardListService implements Service {

	private BoardDAO dao;
	
	// Beans를 통해서 생성한 후 저장하고 있다.
	public BoardListService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<BoardDTO> service(Object[] objs) throws Exception {
		//데이터 변환- 리스트는 넘어오는 데이터가 없으므로 objs를 버린다.
		
		return dao.list();
	}

}
