package com.webjjang.image.service;



import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Service;

public class ImageUpdateService implements Service {

	private ImageDAO dao;
	public ImageUpdateService(ImageDAO dao) {
		this.dao = dao;
	}
	// 데이터 Controller <-> DAO
	public Object service(Object[] objs) throws Exception {
		// 데이터 처리부분에 해당된다.
		System.out.println("ImageUpdateService.service()");

		ImageDTO dto = (ImageDTO) objs[0];
		// 게시판 글수정에서 오류가 나고 있다는 처리를 할 때 예외처리를 해준다. -> 알맞은 메시지로 바꿔서 리턴한다.
		try {
		// 데이터를 컨트롤러에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardUpdateService - [BoardDAO]
			return dao.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예외메시지를 셋팅해서 다시 던지기를 할 수 있다.
			// 사용자를 위한 예외처리
//			throw new Exception("게시판 글수정 중 오류가 발생되었습니다.");
			// 개발자를 위한 예외처리
			throw e;
		}
			}
}
