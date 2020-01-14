package com.webjjang.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class NoticeController implements Controller {

	private Service listService;
	private Service viewService;
//	private Service writeService;
//	private Service updateService;
//	private Service deleteService;
	
	public NoticeController(Service listService,Service viewService, Service writeService, Service updateService, Service deleteService) {
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
		case "/notice/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject));
			jsp = "notice/list";
			break;
		case "/notice/view.do":
			no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("dto", Execute.service(viewService, no));
			jsp = "notice/view";
			break;
			
		

		default:
			break;
		}
		return jsp;
	}

}
