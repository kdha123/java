package service;


import main.Service;

public class DeleteService implements Service {

	@Override
	public Object service(Object ... objs) {
		// View 서비스는 글번호,조회수 1증가 데이터가 넘어온다.
		System.out.println("DeleteService.service()");
//		Integer no = (Integer)objs[0];
		return null;
	}

}
