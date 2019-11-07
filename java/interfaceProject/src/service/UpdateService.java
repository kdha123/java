package service;


//import dto.DTO;
import main.Service;

public class UpdateService implements Service {

	@Override
	public Object service(Object ... objs) {
		// View 서비스는 글번호,조회수 1증가 데이터가 넘어온다.
		System.out.println("UpdateService.service 실행");

//		DTO dto = (DTO)objs[0];
		return 1;
	}

}
