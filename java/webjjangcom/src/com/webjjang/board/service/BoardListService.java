package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> service() throws Exception {
		// ������ ó���κп� �ش�ȴ�.
		
		System.out.println("BoardListService.service()");
		
		// �����͸� ����Ŭ���� �������� ���ؼ� ��ü�� �����ϰ� ȣ���Ѵ�.
		BoardDAO dao = new BoardDAO();
		return dao.list();
		// BoardController - BoardListService - [BoardDAO]
			}
}
