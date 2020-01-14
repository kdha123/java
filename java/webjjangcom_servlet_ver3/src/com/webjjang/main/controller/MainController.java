package com.webjjang.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class MainController implements Controller {
	
	//공지사항 리스트 서비스
	private Service noticeListService;
	// 이미지 리스트 서비스
	private Service imageListService;
	
	public MainController(Service noticeListService, Service imageListService) {
		super();
		this.imageListService = imageListService;
		this.noticeListService = noticeListService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		
		//공지사항 데이터 가져오기. - 1페이지, 7 perPageNum
		// 기본 생성자를 이용해서 PageObject를 생성하면 기본값인 page:1, perPageNum:10
		PageObject pageObject = new PageObject(1,5);
		request.setAttribute("noticeList", Execute.service(noticeListService, pageObject));

		// 이미지 게시판 데이터 가져오기. - 1페이지, 8perPageNum
		pageObject = new PageObject(1,8);
		request.setAttribute("imageList", Execute.service(imageListService, pageObject));
		return "main/main";
	}

}
