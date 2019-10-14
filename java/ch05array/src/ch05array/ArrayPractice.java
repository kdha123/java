package ch05array;

import java.util.Scanner;

public class ArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 학생수를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생 수를 입력해주세요.");
		int student = Integer.parseInt(scanner.nextLine());
		// 학생 수 만큼 점수를 입력 받는다. - 배열 사용
		int[] students = new int[student];
		int sum = 0;
		for(int i = 0; i < students.length; i++)
			students[i] = i * 10 + 50;
		
		// 합계 와 평균을 구한다.
		int avg = 0;
		for(int s : students) {
			// 출력은 학생들의 점수를 출력한다.
			System.out.println(s);
			sum += s;
			avg = sum / student;
		}

		// 합계와 평균을 출력한다.
		System.out.println("합계 : "+ sum);
		System.out.println("평균 : " + avg);
		scanner.close();
	}

}
