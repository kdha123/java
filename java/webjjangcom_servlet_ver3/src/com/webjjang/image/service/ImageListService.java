package com.webjjang.image.service;

import java.util.List;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class ImageListService implements Service {

	private ImageDAO dao;
	
	public ImageListService(ImageDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<ImageDTO> service(Object[] objs) throws Exception {
		// 데이터 변환
		PageObject pageObject = (PageObject) objs[0];
		
		// 데이터 처리부분에 해당된다.
		
		System.out.println("ImageListService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardListService - [BoardDAO]
		// 전체 데이터의 갯수를 구해서 pageObject에 넣는다. -> 전체 페이지가 자동으로 구해진다.
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("ImageListService.service().pageObject:" + pageObject);
		
		
		return dao.list(pageObject);
			}
}
