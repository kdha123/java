package com.webjjang.board.service;


import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardViewService {

	// �����ʹ� Controller <-> DAO
	// �۹�ȣ�� COntroller ���� �޾Ƽ� ó���Ѵ�.
	public BoardDTO service(int no) throws Exception {
		// ������ ó���κп� �ش�ȴ�.
		
		System.out.println("BoardViewService.service()");
		
		// �����͸� ����Ŭ���� �������� ���ؼ� ��ü�� �����ϰ� ȣ���Ѵ�.
		BoardDAO dao = new BoardDAO();
		return dao.view(no);
		// BoardController - BoardViewService - [BoardDAO]
			}
}
