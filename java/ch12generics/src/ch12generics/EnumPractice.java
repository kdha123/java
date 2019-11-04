package ch12enum;

import java.util.Scanner;

// enum 선언
enum Days{SUN,MON,TUE,WEN,THU,FRI,SAT}
public class EnumPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// 사용자가 요일 문자열을 입력한다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("요일을 영어대문자 3자리로 입력해주세요.");
		String day = scanner.nextLine();
		scanner.close();

		try {
			// 받은 문자열을 Days 값으로 변환해서 Days 타입의 변수에 입력 
			Days days = Days.valueOf(day);
			// 입력한 문자열을 enum에 넣고 출력한다.
			System.out.println(days);

			// 잘못된 요일 문자열이 들어온 경우 예외처리 해서 경고 출력
		}catch (Exception e) {

			System.out.println("잘못된 문자열을 입력하셨습니다.");
			System.out.println("다시시도해주세요.");

		}
	}
}
