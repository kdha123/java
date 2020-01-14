package com.webjjang.member.service;

import com.webjjang.main.Service;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.memberDTO;

public class MemberJoinService implements Service {

	private MemberDAO dao;
	
	// 파라메터를 이용해서 생성하면서 dao를 넣어준다. -> Beans에서 처리
	public MemberJoinService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Integer service(Object[] objs) throws Exception {
		
		memberDTO dto = (memberDTO) objs[0];
		return dao.join(dto);
	}

}
