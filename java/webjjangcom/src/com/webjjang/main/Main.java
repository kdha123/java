/*
 * 메뉴구성도
 * [main]
 * 1. 공지사항
 * 2. 게시판
 * 3. 이미지
 * 4. 질문답변
 * 5. 메세지
 * 6. 회원관리
 * 0. 종료
 */
package com.webjjang.main;

import java.util.Scanner;

public class Main {

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
			if(menu.equals("1"))
				System.out.println("공시사항처리");
			else if(menu.equals("2"))
				System.out.println("게시판처리");
			else if(menu.equals("3"))
				System.out.println("이미지처리");
			else if(menu.equals("4"))
				System.out.println("질문답변처리");
			else if(menu.equals("5"))
				System.out.println("메세지처리");
			else if(menu.equals("6"))
				System.out.println("회원관리처리");
			else if(menu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				}
			else System.out.println("잘못된 메뉴를 입력하셨습니다. \n 다시 입력해 주세요.");
		}
	}

}
