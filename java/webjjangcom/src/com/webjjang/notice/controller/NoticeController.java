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

import java.util.Scanner;

public class NoticeController {

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);
	
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
		
		// 공지사항을 무한 반복 처리 - 0을 입력하면 이전 메뉴로 간다.(Main)
		while(true) {
			// 공지사항메뉴 출력
			System.out.println("1.리스트 2.보기 3.등록");
			System.out.println("4.수정 5.삭제 0.이전메뉴");
			
			// 메인메뉴 번호 선택
			System.out.println("메뉴의 번호를 입력하세요");
			String menu = scanner.nextLine();
			// 메인 메뉴 처리
			switch (menu) {
			case "1":
				System.out.println("공시사항 리스트 처리");
				// switch 문을 빠져 나간다.
				// break : switch, for, while 문을 빠져나갈때 사용한다.
				// break가 없는 경우는 case에 맞는 값이라서 case 아래로 처리하기 위해 들어오면
				// 그 아래로 case와 상관없이 처리문을 처리하게 된다.
				break;
			case "2":
				System.out.println("공지사항 보기 처리");
				break;
			case "3":
				System.out.println("공지사항 등록 처리");
				break;
			case "4":
				System.out.println("공지사항 수정 처리");
				break;
			case "5":
				System.out.println("공지사항 삭제 처리");
				break;
			case "0":
				// 호출한 곳으로 돌아가라는 명령어 : return : SwitchMain.main()
				return;

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. \n 다시 입력해 주세요.");
				break;
			}
		}
	}

}
