package ch03operator;

import java.util.Scanner;

public class OperatorEx32Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 값을 넣어서 처리할 변수 선언
		int x;
		String str;
		
		// 값을 키보드로 입력을 받는다.
		// 문자열로 저장된 str의 값을 int로 변환
		Scanner scanner = new Scanner(System.in);
		System.out.println("값을 입력해주세요: -->");
		str = scanner.nextLine();
		x = Integer.parseInt(str);
		
		// 입력된 값의 절대값을 구한다. -값을 +값으로 변환시킨다. ex) -5 -> +5
		// if(조건: -값)-x
		// if(x < 0)x = -x;
		// 조건 ? true값 : false일때 값
		x = (x < 0) ? -x : x;
		
		//값을 출력한다.
		System.out.println(str);
		System.out.println(x);
		
		//scanner 닫기
		scanner.close();
	}

}
