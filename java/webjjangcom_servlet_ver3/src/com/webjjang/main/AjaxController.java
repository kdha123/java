package com.webjjang.main;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.main.Controller;
import com.webjjang.main.Service;

public class AjaxController implements Controller {

	
	private Service memberIdCheckService; //회원 아이디 자동 체크시 사용
	
	// setter를 이용해서 service DI적용.
	public void setMemberIdCheckService(Service memberIdCheckService) {
		this.memberIdCheckService = memberIdCheckService;
	}
	
	public AjaxController() {}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		//서버에서 클라이언트 방향으로 데이터를 전송하기 위한 객체꺼내기
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		switch (uri) {
		//회원가입
		case "/ajax/idCheck.do":
			System.out.println("AjaxController.execute(). - idCheck");
			String id = (String)memberIdCheckService.service(new Object[] {request.getParameter("id")});
			if(id == null)
				out.print("<span style='color:blue'>사용 가능한 아이디 입니다.</span>");
			else
				out.print("<span style='color:red'>중복된 아이디 입니다.</span>");
			break;

		default:
			break;
		}
		
		return null;
	}

}
