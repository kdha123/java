package ch05array;

import java.util.Scanner;

public class ArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �л����� �Է¹޴´�.
		Scanner scanner = new Scanner(System.in);
		System.out.println("�л� ���� �Է����ּ���.");
		int student = Integer.parseInt(scanner.nextLine());
		// �л� �� ��ŭ ������ �Է� �޴´�. - �迭 ���
		int[] students = new int[student];
		int sum = 0;
		for(int i = 0; i < students.length; i++)
			students[i] = i * 10 + 50;
		
		// �հ� �� ����� ���Ѵ�.
		int avg = 0;
		for(int s : students) {
			// ����� �л����� ������ ����Ѵ�.
			System.out.println(s);
			sum += s;
			avg = sum / student;
		}

		// �հ�� ����� ����Ѵ�.
		System.out.println("�հ� : "+ sum);
		System.out.println("��� : " + avg);
		scanner.close();
	}

}
