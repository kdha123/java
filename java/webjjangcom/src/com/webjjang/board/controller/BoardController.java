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
import java.util.Scanner;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.main.Controller;
import com.webjjang.view.BoardView;

public class BoardController implements Controller{

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);
	
	@Override
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
		
		System.out.println("---------------");
		System.out.println("---- 일반 게시판 ----");
		System.out.println("---------------");
		// 게시판을 무한 반복 처리 - 0을 입력하면 이전 메뉴로 간다.(Main)
		while(true) {
			try {
			// 게시판메뉴 출력
			System.out.println();
			System.out.println("1.리스트 2.보기 3.등록");
			System.out.println("4.수정 5.삭제 0.이전메뉴");
			// 메인메뉴 번호 선택
			System.out.println("메뉴의 번호를 입력하세요");
			String menu = scanner.nextLine();
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
				System.out.println("보여줄 글번호를 입력하세요.");
				int no = Integer.parseInt(scanner.nextLine());
				BoardViewService boardViewService = new BoardViewService();
				// 데이터 가져오기
				BoardDTO dto = boardViewService.service(no);
				// 생성하고 호출
				//데이터 출력(생성->호출)
				BoardView boardView2 = new BoardView();
				boardView2.view(dto);
				break;
			case "3":
				System.out.println("게시판 등록 처리");
				break;
			case "4":
				System.out.println("게시판 수정 처리");
				break;
			case "5":
				System.out.println("게시판 삭제 처리");
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
			System.out.println("게시판을 처리하는 중 오류가 발생되었습니다.");
			System.out.println("잠시 후에 다시 시도해 주세요.");
			System.out.println("계속 진행이 안되면 전산담당자 에게 연락해 주세요.");
		}
	}
	}

}
