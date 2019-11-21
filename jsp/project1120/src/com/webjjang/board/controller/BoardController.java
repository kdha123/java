package com.webjjang.board.controller;

import javax.servlet.http.HttpServletRequest;

import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;

public class BoardController implements Controller {

	// 실행에 필요한 객체 선언
	private Service boardListService;
	
	// 생성자를 이용해서 Beans에서 생성하고 service를 생성하고 넣어준다.(DI 적용)
	public BoardController(Service boardListService) {
		// TODO Auto-generated constructor stub
		this.boardListService = boardListService;
		}
	
	@Override
	public String execute(HttpServletRequest request, String uri) throws Exception {
		// TODO Auto-generated method stub
		String jsp ="";
		
		switch (uri) {
		case "/board/list.do":
			request.setAttribute("list", Execute.service(boardListService, 1));
			// FREFIX + jsp + SURFIX -> "/WEB-INF/views/" + jsp + ".jsp"
			jsp="board/list";
			break;

		default:
			break;
		}
		
		return jsp;
	}

}
