package com.webjjang.member.service;

import com.webjjang.main.Service;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.LoginDTO;

public class MemberLoginService implements Service {

	private MemberDAO dao;
	
	// 파라메터를 이용해서 생성하면서 dao를 넣어준다. -> Beans에서 처리
	public MemberLoginService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public LoginDTO service(Object[] objs) throws Exception {
		
		LoginDTO dto = (LoginDTO) objs[0];
		return dao.login(dto);
	}

}
