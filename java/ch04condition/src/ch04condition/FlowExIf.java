/*
 * 버스 요금을 계산하는 프로그램 작성
 * 정상요금 : 1,250원
 * 65세 이상 : 50%
 * 20세~64세 : 정상요금
 * 14세~19세 : 70%
 * 7세~13세 : 50%
 * 0세~6세 : 무료  
 * 10단위에서 절삭 100원 단위로 계산하는 처리
 */
package ch04condition;

import java.util.Scanner;

public class FlowExIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fee = 1250;
		int age;
		// 나이입력받기
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력해주세요: -->");
		age = Integer.parseInt(scanner.nextLine());
		System.out.println("입력한 나이 : "+age);
		

		int charge = (fee / 100) *100 ;
		int charge2 = (fee / 100) *50 ;
		int charge3 = (fee / 100) *70 ;
		
		if(age <= 6) System.out.println("무료입니다.");
		else if(age >= 7 && age <= 13) System.out.println("가격은"+charge2+"원 입니다.");
		else if(age >= 14 && age <= 19) System.out.println("가격은"+charge3+"원 입니다.");
		else if(age >= 20 && age <= 64) System.out.println("가격은"+charge3+"원 입니다.");
		else if(age >= 65) System.out.println("가격은"+(charge2)+"원 입니다.");
		
		scanner.close();
	}

}
