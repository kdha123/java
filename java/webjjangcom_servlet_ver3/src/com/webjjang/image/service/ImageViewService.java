package com.webjjang.image.service;


import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Service;

public class ImageViewService implements Service {

	private ImageDAO dao;
	public ImageViewService(ImageDAO dao) {
		this.dao = dao;
	}
	// 데이터는 Controller <-> DAO
	// 글번호를 COntroller 에서 받아서 처리한다.
	@Override
	public ImageDTO service(Object[] objs) throws Exception {
		// 데이터 처리부분에 해당된다.
		
		System.out.println("ImageViewService.service()");
		int no = (int) objs[0];
				
	
		return dao.view(no);
		// BoardController - BoardViewService - [BoardDAO]
			}
}
