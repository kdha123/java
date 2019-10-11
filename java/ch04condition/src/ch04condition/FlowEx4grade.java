/*
 * 학점계산기 만들기
 * 90점이상 A, 80점이상 B, 70점 이상 C, 60점 이상 D, 0점 이상 F
 * 100점이상 오류 처리
 */
package ch04condition;

import java.util.Scanner;

public class FlowEx4grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score;
		String grade = "";
		
		// 점수를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력해주세요: -->");
		// 점수를 출력한다.
		score = Integer.parseInt(scanner.nextLine());
		System.out.println("입력한 점수 : "+score);
		// 평점을 구한다. A ~ F
		if(score > 100) grade = "점수오류 ";
		else if(score >= 90 ) grade = "A";
		else if(score >= 80 ) grade = "B";
		else if(score >= 70 ) grade = "C";
		else if(score >= 60 ) grade = "D"; 
		else if(score >= 0 ) grade = "F";
		else grade = "오류";
		
		// 점수가 0보다 작거나 100보다 크면 점수 입력 오류로 처리
		
		//평점을 출력한다.
		System.out.println("당신의 학점은"+ grade +"입니다.");
		
		scanner.close();
	}

}
