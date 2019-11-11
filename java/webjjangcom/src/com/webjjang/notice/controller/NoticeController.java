/*
 * 공지사항
 * [notice]
 * 1. 리스트
 * 2. 보기
 * 3. 등록
 * 4. 수정
 * 5. 삭제
 * 0. 이전메뉴
 */
package com.webjjang.notice.controller;


import java.util.List;

import com.webjjang.main.Controller;
import com.webjjang.main.Service;
import com.webjjang.main.SwitchMain;
import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.OutPut;
import com.webjjang.view.NoticeView;

public class NoticeController implements Controller {
	
	// 각각의 서비스 변수-> 생성할 때 초기값으로 생성된 객체를 넣어준다.
	private final Service noticeListService;
	private final Service noticeViewService;
	private final Service noticeWriteService;
	private final Service noticeUpdateService;
	private final Service noticeDeleteService;
	
	//생성자 -> 생성할 때 딱 한번 실행 -> 생성을 Beans에서 딱 한번만 하고 있다.
	// 각각의 서비스를 전달 받아 private 변수에 넣는다.
	public NoticeController(Service noticeListService, Service noticeViewService,
			Service noticeWriteService,Service noticeUpdateService,
			Service noticeDeleteService) {
		this.noticeDeleteService = noticeDeleteService;
		this.noticeListService = noticeListService;
		this.noticeViewService = noticeViewService;
		this.noticeWriteService = noticeWriteService;
		this.noticeUpdateService = noticeUpdateService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
		
		// 공지사항을 무한 반복 처리 - 0을 입력하면 이전 메뉴로 간다.(Main)
		while(true) {
			// 공지사항메뉴 출력
			OutPut.menu("1.리스트 2.보기 3.등록","4.수정 5.삭제 0.이전메뉴");
			
			// 메인메뉴 번호 선택
			String menu = Input.getStringWithMessage("메뉴를 입력해주세요");
			try {
				
			// 메인 메뉴 처리
			switch (menu) {
			case "1":
				System.out.println("공시사항 리스트 처리");
				// switch 문을 빠져 나간다.
				// break : switch, for, while 문을 빠져나갈때 사용한다.
				// break가 없는 경우는 case에 맞는 값이라서 case 아래로 처리하기 위해 들어오면
				// 그 아래로 case와 상관없이 처리문을 처리하게 된다.
				List<NoticeDTO> list = (List<NoticeDTO>)SwitchMain.service(noticeListService, 1);
				NoticeView.list(list);
				break;
			case "2":
				System.out.println("공지사항 보기 처리");
				
				NoticeDTO dto = (NoticeDTO)SwitchMain.service(noticeViewService, Input.getIntWithMessageOfSmart("보고싶은 번호를 입력해주세요."));
				NoticeView.view(dto);
				break;
			case "3":
				System.out.println("공지사항 등록 처리");
				SwitchMain.service(noticeWriteService, inDTO());
				break;
			case "4":
				System.out.println("공지사항 수정 처리");
				NoticeDTO noticeDTO = getDTO("수정할 글 번호를 입력하세요.");
				changeData(noticeDTO);
				System.out.println(noticeDTO);
				SwitchMain.service(noticeUpdateService, noticeDTO);
				break;
			case "5":
				System.out.println("공지사항 삭제 처리");
				SwitchMain.service(noticeDeleteService, Input.getIntWithMessageOfSmart("삭제할 글 번호를 입력하세요."));
				break;
			case "0":
				// 호출한 곳으로 돌아가라는 명령어 : return : SwitchMain.main()
				return;

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. \n 다시 입력해 주세요.");
				break;
			}// end of switch
			}catch (Exception e) {
				e.printStackTrace();
			}
		}// end while
	}// end of execute()
	private NoticeDTO inDTO() {
		return new NoticeDTO(
				Input.getStringWithMessage("제목 :"),
				Input.getStringWithMessage("내용 :"),
				Input.getStringWithMessage("시작일 :"),
				Input.getStringWithMessage("종료일 :"));
	}
//	 DB에서 DTO 가져오는 프로그램 작성
		public NoticeDTO getDTO(String msg) throws Exception {
			// 글 번호를 받는다.
			int no = Input.getIntWithMessageOfSmart(msg);
			// 데이터 가져오기 - > Controller.getDTO() -> view : 조회수 1 증가시키지 않는다. : 0
			NoticeDTO dto = (NoticeDTO)SwitchMain.service(noticeViewService, no);
			// 생성하고 호출
			//데이터 출력(생성->호출)
			NoticeView.view(dto);
			// view에서는 버린다. update에서는 수정할 때 사용한다.
			return dto;
		}
		
		// 가져온 데이터를 수정하는 메서드
		public void changeData(NoticeDTO dto) {
			//입력데이터가 0이 될때까지 무한 반복
			while(true) {			
				//변경할 데이터를 선택
				System.out.println("변경 내용선택 -------------");
				System.out.println("1. 제목, 2. 내용, 3.시작일, 4.종료일 ,  0. 수정완료");
				String menu = Input.getStringWithMessage("수정 항목 선택");
				
				// 수정할 데이터 입력받는다.
				switch (menu) {
				case "1":
					dto.setTitle(Input.getStringWithMessage("제목"));
					break;
				case "2":
					dto.setContent(Input.getStringWithMessage("내용"));
					break;
				case "3":
					dto.setStartDate(Input.getStringWithMessage("시작일"));
					break;
				case "4":
					dto.setEndDate(Input.getStringWithMessage("종료일"));
					break;
				case "0":
					return;

				default:
					System.out.println("잘못된 항목을 선택하셨습니다.");
					break;
				}
				
				// 데이터가 수정이 되었으면 출력해서 확인할 수 있도록 제공한다.
				NoticeView.view(dto); 
				
			}
}

}// end of NoticeController class
