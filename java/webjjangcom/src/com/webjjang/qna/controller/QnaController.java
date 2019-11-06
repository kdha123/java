package com.webjjang.qna.controller;

import java.util.List;

import com.webjjang.exception.NotLoginException;
import com.webjjang.main.Controller;
import com.webjjang.main.SwitchMain;
import com.webjjang.qna.dto.QnaDTO;
import com.webjjang.qna.service.QnaAnswerService;
import com.webjjang.qna.service.QnaDeleteService;
import com.webjjang.qna.service.QnaListService;
import com.webjjang.qna.service.QnaUpdateService;
import com.webjjang.qna.service.QnaViewService;
import com.webjjang.qna.service.QnaWriteService;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.OutPut;
import com.webjjang.view.QnaView;


public class QnaController implements Controller{
	
//public static Scanner scanner = new Scanner(System.in);
	
	@Override
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
		
		OutPut.title("질문답변");
		// 질문답변 게시판 처리를 무한 반복 처리 - 0을 입력하면 이전 메뉴로 간다.(Main)
		while(true) {
			try {
			// 게시판메뉴 출력
				OutPut.menu("1.리스트  2.보기  3.질문하기  4.답변하기",
						"5.수정  6.삭제  0.이전메뉴");
		
			// 메인메뉴 번호 선택
			String menu = Input.getStringWithMessage("메뉴의 번호를 입력하세요");
			// 메인 메뉴 처리
			switch (menu) {
			case "1":
				System.out.println("질문답변 리스트 처리");
				// 객체 생성 : qnaController -> QnaListService 
				//                         -> QnaDAO
				QnaListService qnaListService = new QnaListService();
				// 데이터 가져오기 -> 메서드 호출
				List<QnaDTO> list = qnaListService.service();
				// 가져온 데이터를 출력(객체를 생성 ->메서드 호출)
				QnaView qnaView = new QnaView();
				qnaView.list(list);
				// try catch를 오류를 한번에 다 잡을 수 있게 된다.
				break;
			case "2":
				System.out.println("질문답변 보기 처리");
				// Controller.main()-> view : hit = hit + 1 -> DAO
				// 조회수 1 증가 시킨다. : 1을 넘긴다.
				// list를 먼저 실행하시고 있는 글번호를 선택한다.
				// 가져온 데이터를 출력(객체를 생성 ->메서드 호출)
				new QnaView().view(new QnaViewService()
						.service(Input.getIntWithMessageOfSmart("보여줄글번호를 입력하세요"), 1));;
				break;
			case "3":
				System.out.println("질문하기");
				
				// 로그인이 필요한 처리이므로 로그인이 되어있지않으면 예외 발생
				if(SwitchMain.login == null)throw new NotLoginException();
				
				// 사용자에게 데이터를 받는다. -> dto 객체로 만든다.
				// 제목, 내용
				QnaDTO inDto = inputDTO();
				// 작성자 id -> 로그인정보에서 가져온다. : 미개발
//				String id = "test"; // 강제로그인
				String id = SwitchMain.login.getId(); // 로그인
				inDto.setId(id);
				// controller -> service -> dao
				QnaWriteService qnaWriteService
				= new QnaWriteService();				
				qnaWriteService.service(inDto);
				break;
			case "4":
				System.out.println("답변하기");
				
				// 로그인이 필요한 처리이므로 로그인이 되어있지않으면 예외 발생
				if(SwitchMain.login == null)throw new NotLoginException();
				
				// 답변할 글번호 받기 - 답변할 QnaDTO를 DB에서 가져온다.
				QnaDTO sourceDTO = getDTO("답변할 글 번호를 입력하세요.");
				// 사용자에게  답변 데이터를 받는다. -> dto 객체로 만든다.
				// 제목, 내용
				QnaDTO inDTO = inputDTO();
				// 답변하는 사람의 아이디 셋팅
				String anwserid = "admin";
				inDTO.setId(anwserid);
				// 사용해야할 번호를 셋팅하는 처리
				inDTO.setOperateNo(sourceDTO);
				// controller -> service -> dao
				QnaAnswerService qnaAnswerService
				= new QnaAnswerService();
				qnaAnswerService.service(inDTO);
				break;
			case "5":
				System.out.println("질문답변 수정 처리");
				
				// 로그인이 필요한 처리이므로 로그인이 되어있지않으면 예외 발생
				if(SwitchMain.login == null)throw new NotLoginException();
				
				// 수정할 글번호를 받는다 -> 글을 가져온다. (viewService)표시
				QnaDTO qnaDTO = getDTO("수정할 글 번호를 입력하세요.");
				// -> 가져온 dto의 데이터를 항목별로 수정한다.
				changeData(qnaDTO);
				System.out.println(qnaDTO);
				// -> DB에 수정처리를 한다.(service->dao)
				QnaUpdateService qnaUpdateService = new QnaUpdateService();
				qnaUpdateService.service(qnaDTO);
				break;
			case "6":
				System.out.println("질문답변 삭제 처리");
				
				// 로그인이 필요한 처리이므로 로그인이 되어있지않으면 예외 발생
				if(SwitchMain.login == null)throw new NotLoginException();
				
				// 삭제할 글번호 받기
				
				// 글번호에 맞는 DB에 데이터를 삭제 - delete
				new QnaDeleteService().service(Input.getIntWithMessageOfSmart("삭제할 글번호 입력"));
				break;
			case "0":
				System.out.println("이전메뉴.");
				return;

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. \n 다시 입력해 주세요.");
				break;
			}
		} catch (NotLoginException e) {
			System.out.println(e.getMessage());
			// 로그인 처리
			SwitchMain.login();
			// 로그인 정보 출력
			OutPut.loginInfo();
		} catch (Exception e) {
			// TODO: handle exception
			// 개발자를 위한 코드
			e.printStackTrace();
			//사용자를 위한 코드
			System.out.println("질문답변을 처리하는 중 오류가 발생되었습니다.");
			System.out.println("잠시 후에 다시 시도해 주세요.");
			System.out.println("계속 진행이 안되면 전산담당자 에게 연락해 주세요.");
		}
	}
	}
	public QnaDTO inputDTO() {
		QnaDTO dto = new QnaDTO();
		dto.setTitle(Input.getStringWithMessage("제목"));
		dto.setContent(Input.getStringWithMessage("내용"));
		return dto;
	}
	// DB에서 DTO 가져오는 프로그램 작성
		public QnaDTO getDTO(String msg) throws Exception {
			// 글 번호를 받는다.
			int no = Input.getIntWithMessageOfSmart(msg);
			QnaViewService qnaViewService = new QnaViewService();
			// 데이터 가져오기 - > Controller.getDTO() -> view : 조회수 1 증가시키지 않는다. : 0
			QnaDTO dto = qnaViewService.service(no, 0);
			// 생성하고 호출
			//데이터 출력(생성->호출)
			QnaView QnaView = new QnaView();
			QnaView.view(dto);
			// view에서는 버린다. update에서는 수정할 때 사용한다.
			return dto;
		}
		
		// 가져온 데이터를 수정하는 메서드
		public void changeData(QnaDTO dto) {
			//입력데이터가 0이 될때까지 무한 반복
			while(true) {			
				//변경할 데이터를 선택
				System.out.println("변경 내용선택 -------------");
				System.out.println("1. 제목, 2. 내용, 0. 수정완료");
				String menu = Input.getStringWithMessage("수정 항목 선택");
				
				// 수정할 데이터 입력받는다.
				switch (menu) {
				case "1":
					dto.setTitle(Input.getStringWithMessage("제목"));
					break;
				case "2":
					dto.setContent(Input.getStringWithMessage("내용"));
					break;
				case "0":
					return;

				default:
					System.out.println("잘못된 항목을 선택하셨습니다.");
					break;
				}
				
				// 데이터가 수정이 되었으면 출력해서 확인할 수 있도록 제공한다.
				new QnaView().view(dto); 
				
			}
}
}