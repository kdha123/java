/*
 * 처음 시작하는  main 부분 : PL이 작성해서 넣어둔다.
 * 각각의 모듈 컨트롤러에서 사용할 메서드를 정의해놓은 인터페이스를 만든다.
 * 각각의 모듈 컨트롤러를 작성할 때에 반드시 인터페이스를 상속받아서 만들어야한다고 강제한다.
 * 메뉴구성도
 * [main]
 * 1. 공지사항
 * 2. 게시판
 * 3. 이미지
 * 4. 질문답변
 * 5. 메세지
 * 6. 회원관리
 * 0. 종료
 * 
 */
package com.webjjang.main;

import java.util.Scanner;

import com.webjjang.board.controller.BoardController;
import com.webjjang.notice.controller.NoticeController;

public class SwitchMain {

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 메인을 무한 반복 처리 - 0을 입력하면 종료시킨다.
		while(true) {
			// 메인메뉴 출력
			System.out.println("1.공지사항 2.게시판 3.이미지");
			System.out.println("4.질문답변 5.메세지 6.회원관리");
			System.out.println("0.종료");
			// 메인메뉴 번호 선택
			System.out.println("메뉴의 번호를 입력하세요");
			String menu = scanner.nextLine();
			// 메인 메뉴 처리
			switch (menu) {
			case "1":
				System.out.println("공시사항처리");
				// 객체 생성 - main memory에 올린다. : new
				NoticeController noticeController = new NoticeController();
				// 생성한 객체의 처리문이 들어 있는 메서드를 호출해서 처리하도록 시킨다.
				noticeController.execute();
				// switch 문을 빠져 나간다.
				// break : switch, for, while 문을 빠져나갈때 사용한다.
				// break가 없는 경우는 case에 맞는 값이라서 case 아래로 처리하기 위해 들어오면
				// 그 아래로 case와 상관없이 처리문을 처리하게 된다.
				break;
			case "2":
				System.out.println("게시판처리");
				BoardController BoardController = new BoardController();
				BoardController.execute();
				break;
			case "3":
				System.out.println("이미지처리");
				break;
			case "4":
				System.out.println("질문답변처리");
				break;
			case "5":
				System.out.println("메세지처리");
				break;
			case "6":
				System.out.println("회원관리처리");
				break;
			case "0":
				System.out.println("종료처리");
				// 시스템 종료 - 0:정상종료 - 종료명령으로 종료가 이뤄졌다.
				System.exit(0);

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. \n 다시 입력해 주세요.");
				break;
			}
		}
	}

}
