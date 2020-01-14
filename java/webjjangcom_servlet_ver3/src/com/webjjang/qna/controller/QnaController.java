package com.webjjang.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class QnaController implements Controller {

	private Service listService;
	private Service viewService;
//	private Service writeService;
//	private Service updateService;
//	private Service deleteService;
	
	public QnaController(Service listService,Service viewService, Service writeService, Service updateService, Service deleteService) {
		// TODO Auto-generated constructor stubs
		this.listService = listService;
		this.viewService = viewService;
//		this.writeService = writeService;
//		this.updateService = updateService;
//		this.deleteService = deleteService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		String jsp = "";
		int no;
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"),request.getParameter("perPageNum"));
				
		switch (uri) {
		case "/qna/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject));
			jsp = "qna/list";
			break;
		case "/qna/view.do":
			no = Integer.parseInt(request.getParameter("no"));
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			request.setAttribute("dto", Execute.service(viewService, no, cnt));
			jsp = "qna/view";
			break;
			//write는 로그인처리
		

		default:
			break;
		}
		return jsp;
	}

}
