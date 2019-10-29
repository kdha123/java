package com.webjjang.main;

import java.util.Scanner;


public class SwitchMain {
	
	// Main.scanner.nextLine();  --> main 말고 다른 곳에서 사용할 때?
	public static Scanner scanner = new Scanner(System.in); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 메인을 무한 반복 처리 - 0을 입력하면 종료 시킴
		while (true) {
			// 메인메뉴 출력
			System.out.println("1.공지사항   2.게시판   3.이미지");
			System.out.println("4.질문답변   5.메시지   6.회원관리");
			System.out.println("0.종료\n\n");
			// 메인메뉴 번호 선택
			System.out.println("[Main Menu]");
			System.out.println("메뉴의 번호를 입력하세요.");
			String menu = scanner.nextLine();
			// 메인메뉴 처리 switch - case 문
			switch (menu) {
			case "1":
			
				System.out.println("공지사항 처리");
			
		
				break;
			case "2":
		
				System.out.println("게시판 처리");
		
				
				break;
			case "3":
				System.out.println("이미지 처리");
				break;
			case "4":
				System.out.println("질문답변 처리");
				break;
			case "5":
				System.out.println("메세지 처리");
				break;
			case "6":
				System.out.println("회원관리 처리");
				break;
			case "0":
				System.out.println("프로그램을 종료합니다.");
				// 시스템 종료 - 0: 정상종료 (종료 명령으로 종료가 이뤄짐)
				System.exit(0); //while 문까지 종료

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. \n 다시 입력해 주세요.");
				break;
			}
			
		}
	}
	
}
