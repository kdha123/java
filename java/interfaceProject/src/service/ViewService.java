package service;


import dto.DTO;
import main.Service;

public class ViewService implements Service {

	@Override
	public Object service(Object ... objs) {
		// View 서비스는 글번호,조회수 1증가 데이터가 넘어온다.
		System.out.println("ViewService.service()");
//		Integer no = (Integer)objs[0];
//		Integer inc = (Integer)objs[1];
		return new DTO();
	}

}
