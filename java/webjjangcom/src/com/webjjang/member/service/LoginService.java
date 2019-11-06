package com.webjjang.member.service;


import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.LoginDTO;

public class LoginService {

	// 데이터는 Controller <-> service<-> DAO
	// id,pw를 COntroller 에서 받아서 처리한다.
	public LoginDTO service(LoginDTO dto) throws Exception {
		// 데이터 처리부분에 해당된다.
		
		System.out.println("LoginService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		MemberDAO dao = new MemberDAO();
		return dao.login(dto);
		// BoardController - BoardViewService - [BoardDAO]
			}
}
