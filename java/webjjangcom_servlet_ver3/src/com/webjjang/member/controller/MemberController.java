package com.webjjang.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.main.Controller;
import com.webjjang.main.Service;

public class MemberController implements Controller {

//	private Service listService;
//	private Service viewService;
//	private Service writeService;
//	private Service updateService;
//	private Service deleteService;
//	
	public MemberController(Service listService, Service viewService, Service writeService, Service updateService, Service deleteService) {
		// TODO Auto-generated constructor stub
		
//		this.listService = listService;
//		this.viewService = viewService;
//		this.writeService = writeService;
//		this.updateService = updateService;
//		this.deleteService = deleteService;
		
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		String jsp = "";
		switch (uri) {
		//회원가입
		case "/member/joinForm.do":
			//joinForm.jsp로 바로 이동시킨다.
			jsp = "member/joinForm";
			break;

		default:
			break;
		}
		
		return jsp;
	}

}
