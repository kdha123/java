package com.webjjang.board.service;



import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.Service;

public class BoardDeleteService implements Service{

	private BoardDAO dao;
	public BoardDeleteService(BoardDAO dao) {
		this.dao = dao;
	}
	// 데이터 Controller <-> service <-> DAO
	// 입력받은 글번호를 컨트롤러에서 받아서 삭제처리한다.
	public Object service(Object[] objs) throws Exception {
		// 데이터 처리부분에 해당된다.
		System.out.println("BoardReplyDeleteService.service()");

		int no = (int) objs[0];
		// 게시판 글삭제에서 오류가 나고 있다는 처리를 할 때 예외처리를 해준다. -> 알맞은 메시지로 바꿔서 리턴한다.
		try {
		// 데이터를 컨트롤러에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardWriteService - [BoardDAO]
			return dao.delete(no);
		} catch (Exception e) {
			// 개발자를 위한 오류 출력
			e.printStackTrace();
			// TODO: handle exception
			// 상세한 내용의 예외메시지를 셋팅해서 다시 던지기를 할 수 있다.(사용자용)
			throw new Exception("게시판 글 삭제  중 오류가 발생되었습니다.");
		}
			}
}
