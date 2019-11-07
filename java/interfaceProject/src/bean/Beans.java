package bean;

import java.util.HashMap;
import java.util.Map;

import main.Service;
import service.ListService;
import service.UpdateService;
import service.ViewService;
import service.WriteService;

public class Beans {

	// Service를 담을 수 있는 저장 객체 생성("list" - ListService : map)
	private static Map<String, Service> serviceMap = new HashMap<String, Service>();
	
	// 클래스에 맨처음 한번만 실행되는 초기화 블록 -> 모든 객체는 여기서만 생성을 한다.
	static {
		System.out.println("Beans.static{} : 모든 서비스 객체 생성");
		serviceMap.put("list", new ListService());
		serviceMap.put("view", new ViewService());
		serviceMap.put("write", new WriteService());
		serviceMap.put("update", new UpdateService());
	}
	
	// 키값을 주면 service를 가져오는 메서드
	public static Service getService(String key) {
		// 저장되어 있는 서비스 중 key에 해당이 되는 서비스를 찾아서 넘겨준다.
		return serviceMap.get(key);
	}
}
