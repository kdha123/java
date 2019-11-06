package com.webjjang.util.io;

import com.webjjang.main.SwitchMain;

public class OutPut {

	// 로그인 정보를 출력하는 메서드
	public static void loginInfo() {
		System.out.println("[로그인정보]-----------------");
		if(SwitchMain.login == null)
			System.out.println("로그인 되지 않았습니다.");
		else
			System.out.println(" 환영합니다. " + SwitchMain.login.getName()+ "님은 "
		+ SwitchMain.login.getGradeName()+"권한으로 로그인 하셨습니다.");
		System.out.println("-------------------------");
	}
	
	// 제목 출력
	public static void title(String title) {
		printTitleLine();
		System.out.println("  "+title);
		printTitleLine();
	}
	
	// 메뉴 출력
	// String으로 데이터 여러개 menus[] -> 갯수는 상관이 없다.
	public static void menu(String ...menus) {
		printLine();
		for(String menu : menus)
			System.out.println("  " + menu);
		printLine();
	}
	// 제목 출력시  출력이 되는 라인 출력
	public static void printTitleLine() {
		printLine("=",20);
	}
	
	//라인 출력 - 출력되는 문자, 반복횟수(길이)
	public static void printLine(String type,int cnt) {
		for(int i =1;i <= cnt;i++)
			System.out.print("-");
		System.out.println();
	}
	//라인 출력 - 반복횟수(길이)
	public static void printLine(int cnt) {
		printLine("-",cnt);
	}
	//라인 출력 - 반복횟수(길이)
		public static void printLine() {
			printLine("-",30);
		}
}
