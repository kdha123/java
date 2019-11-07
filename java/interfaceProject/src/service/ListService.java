package service;

import java.util.ArrayList;

import dto.DTO;
import main.Service;

public class ListService implements Service {

	@Override
	public Object service(Object ... objs) {
		// ListService에서는 데이터를 받기만하고 버린다.
		// 실제적으로는 호출하는 쪽에서 null을 넣어준다.
		System.out.println("ListService.service()");
		return new ArrayList<DTO>();
	}

}
