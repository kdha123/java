package ch04condition;

import java.util.Scanner;

public class FlowEx6Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 월 입력
		Scanner scanner = new Scanner(System.in);
		System.out.println("현재 월을 입력해주세요.");
		int month = Integer.parseInt(scanner.nextLine());
	
		//계절처리
		// switch = label(:) 구조를 이용하고 있다. -> 임의의 원하는 위치로 이동
		switch (month) {
		case 3:
			System.out.println(3);
		case 4:
			System.out.println(4);
		case 5:
			System.out.println(5);
			System.out.println("봄");
			break;
			
		case 6:
			System.out.println(6);
		case 7:
			System.out.println(7);
		case 8:
			System.out.println(8);
			System.out.println("여름");
			break;
			
		case 9:
			System.out.println(9);
		case 10:
			System.out.println(10);
		case 11:
			System.out.println(11);
			System.out.println("가을");
			break;

		case 12:
			System.out.println(12);
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
			System.out.println("겨울");
			break;

		default:
			System.out.println("오류");
			break;
		}
		scanner.close();
	}

}
