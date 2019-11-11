/*
 * 프로젝트의 실행되어질 모든 Controller와 Service, DAO 객체를 생성해서 저장하고 있는 객체
 * static{}에서 모든 객체를 생성
 * Map<String, Controller> controller : 생성된 객체를 저장하는 변수
 * Map<String, Service> service : 생성된 객체를 저장하는 변수
 * Map<String, Object> DAO : 생성된 객체를 저장하는 변수
 * 호출해서 사용하려는 곳에서 해당되는 Controller를 받아가는 메서드 : getController()
 * 호출해서 사용하려는 곳에서 해당되는 service를 받아가는 메서드 : getService()
 * 호출해서 사용하려는 곳에서 해당되는 DAO를 받아가는 메서드 : getDAO()
 * BoardController -> BoardListService / BoardViewService -> BoardDAO 
 * 
 */
package com.webjjang.bean;

import java.util.HashMap;
import java.util.Map;

import com.webjjang.main.Controller;
import com.webjjang.main.Service;
import com.webjjang.notice.controller.NoticeController;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.service.NoticeDeleteService;
import com.webjjang.notice.service.NoticeListService;
import com.webjjang.notice.service.NoticeUpdateService;
import com.webjjang.notice.service.NoticeViewService;
import com.webjjang.notice.service.NoticeWriteService;

// 팩토리형식이라고 한다.
public class Beans {
	
	// 각각의 객체를 저장할 map객체 선언하고 생성해 놓는다.
	private static Map<String, Controller> controller = new HashMap<>();
	private static Map<String, Service> service = new HashMap<>();
	private static Map<String, Object> dao = new HashMap<>();
	
	//초기화 블록 -> 위에 있는 map 객체들을 초기화 한다.
	static {
		System.out.println("객체 초기화중");
		//공지사항
		//dao생성
		dao.put("noticeDAO", new NoticeDAO());
		// service 생성
		service.put("noticeListService", new NoticeListService((NoticeDAO) dao.get("noticeDAO")));
		service.put("noticeViewService", new NoticeViewService((NoticeDAO) dao.get("noticeDAO")));
		service.put("noticeWriteService", new NoticeWriteService((NoticeDAO) dao.get("noticeDAO")));
		service.put("noticeUpdateService", new NoticeUpdateService((NoticeDAO) dao.get("noticeDAO")));
		service.put("noticeDeleteService", new NoticeDeleteService((NoticeDAO) dao.get("noticeDAO")));
		//controller 생성 저장
		controller.put("noticeController", new NoticeController(service.get("noticeListService"),
				service.get("noticeViewService"),
				service.get("noticeWriteService"),
				service.get("noticeUpdateService"),
				service.get("noticeDeleteService")));
		System.out.println("객체 초기화 완료");
	}

	//Controller를 받아내는 메서드 작성
	public static Controller getController(String name) {
		return controller.get(name);
	}
	
}
