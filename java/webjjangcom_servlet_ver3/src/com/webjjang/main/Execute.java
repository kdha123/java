package com.webjjang.main;

public class Execute {

	// 서비스를 실행하는 메서드 작성 - 모든 서비스는 이 메서드를 사용해서 실행해야만 한다.
	//service(실행객체, 넘겨질 파라메터) -> 넘겨질 파라메터는 알맞게 캐스팅해서 사용하는 것으로 한다.
	// proxy 형태라고 함.
	public static Object service(Service service, Object ...objs) throws Exception {
		return service.service(objs);
	}
	
	
}
