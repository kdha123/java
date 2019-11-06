/*
 * 게시판메뉴 
 * [board]
 * 1. 리스트
 * 2. 보기
 * 3. 등록
 * 4. 수정
 * 5. 삭제
 * 0. 이전메뉴
 */
package com.webjjang.board.controller;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.service.BoardDeleteService;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardUpdateService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.board.service.BoardWriteService;
import com.webjjang.main.Controller;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.OutPut;
import com.webjjang.view.BoardView;

public class BoardController implements Controller{

	// Main.scanner.nextLine();
//	public static Scanner scanner = new Scanner(System.in);
	
	@Override
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
		
		OutPut.title("일반게시판");
		// 게시판을 무한 반복 처리 - 0을 입력하면 이전 메뉴로 간다.(Main)
		while(true) {
			try {
			// 게시판메뉴 출력
			OutPut.menu("1.리스트  2.보기  3.등록",
					"4.수정  5.삭제  0.이전메뉴");
			// 메인메뉴 번호 선택
//			System.out.println("메뉴의 번호를 입력하세요");
			String menu = Input.getStringWithMessage("메뉴의 번호를 입력하세요");
			// 메인 메뉴 처리
			switch (menu) {
			case "1":
				System.out.println("게시판 리스트 처리");
				// 객체 생성 : BoardController -> BoardListService 
				//                         -> BoardDAO
				BoardListService boardListService = new BoardListService();
				// 데이터 가져오기 -> 메서드 호출
				List<BoardDTO> list = boardListService.service();
				// 가져온 데이터를 출력(객체를 생성 ->메서드 호출)
				BoardView boardView = new BoardView();
				boardView.list(list);
				// try catch를 오류를 한번에 다 잡을 수 있게 된다.
				break;
			case "2":
				System.out.println("게시판 보기 처리");
				// list를 먼저 실행하시고 있는 글번호를 선택한다.
				getDTO("보여줄 글 번호를 입력하세요.");
				break;
			case "3":
				System.out.println("게시판 등록 처리");
				// 사용자에게 데이터를 받는다. -> dto 객체로 만든다.
				// 제목, 내용, 작성자
//				BoardDTO inDto = inputDTO();
				// controller -> service -> dao
				BoardWriteService boardWriteService
				= new BoardWriteService();
				boardWriteService.service(inputDTO());
				break;
			case "4":
				System.out.println("게시판 수정 처리");
				// 수정할 글번호를 받는다 -> 글을 가져온다. (viewService)표시
				BoardDTO boardDTO = getDTO("수정할 글 번호를 입력하세요.");
				// -> 가져온 dto의 데이터를 항목별로 수정한다.
				changeData(boardDTO);
				System.out.println(boardDTO);
				// -> DB에 수정처리를 한다.(service->dao)
				BoardUpdateService boardUpdateService = new BoardUpdateService();
				boardUpdateService.service(boardDTO);
				break;
				
				
			case "5":
				System.out.println("게시판 삭제 처리");
				// 삭제할 글번호 받기
				
				// 글번호에 맞는 DB에 데이터를 삭제 - delete
				new BoardDeleteService().service(Input.getIntWithMessageOfSmart("삭제할 글번호 입력"));
				break;
			case "0":
				System.out.println("이전메뉴.");
				return;

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. \n 다시 입력해 주세요.");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// 개발자를 위한 코드
			e.printStackTrace();
			//사용자를 위한 코드
			System.out.println(e.getMessage());
			System.out.println("게시판을 처리하는 중 오류가 발생되었습니다.");
			System.out.println("잠시 후에 다시 시도해 주세요.");
			System.out.println("계속 진행이 안되면 전산담당자 에게 연락해 주세요.");
		}
	}
	}

	//게시판의 내용을 입력받는 메서드 -> dto생성 -> 제목, 내용 , 작성자입력하고 리턴한다.
	public BoardDTO inputDTO() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(Input.getStringWithMessage("제목"));
		dto.setContent(Input.getStringWithMessage("내용"));
		dto.setWriter(Input.getStringWithMessage("작성자"));
		return dto;
	}
	
	// DB에서 DTO 가져오는 프로그램 작성
	public BoardDTO getDTO(String msg) throws Exception {
		// 글 번호를 받는다.
		int no = Input.getIntWithMessageOfSmart(msg);
		BoardViewService boardViewService = new BoardViewService();
		// 데이터 가져오기
		BoardDTO dto = boardViewService.service(no);
		// 생성하고 호출
		//데이터 출력(생성->호출)
		BoardView boardView = new BoardView();
		boardView.view(dto);
		// view에서는 버린다. update에서는 수정할 때 사용한다.
		return dto;
	}
	
	// 가져온 데이터를 수정하는 메서드
	public void changeData(BoardDTO dto) {
		//입력데이터가 0이 될때까지 무한 반복
		while(true) {			
			//변경할 데이터를 선택
			System.out.println("변경 내용선택 -------------");
			System.out.println("1. 제목, 2. 내용, 3. 작성자, 0. 수정완료");
			String menu = Input.getStringWithMessage("수정항목선택");
			
			// 수정할 데이터 입력받는다.
			switch (menu) {
			case "1":
				dto.setTitle(Input.getStringWithMessage("제목"));
				break;
			case "2":
				dto.setContent(Input.getStringWithMessage("내용"));
				break;
			case "3":
				dto.setWriter(Input.getStringWithMessage("작성자"));
				break;
			case "0":
				return;

			default:
				System.out.println("잘못된 항목을 선택하셨습니다.");
				break;
			}
			
			// 데이터가 수정이 되었으면 출력해서 확인할 수 있도록 제공한다.
			new BoardView().view(dto); 
			
		}
		
	}
}
