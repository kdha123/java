/*
 * �������� �����
 * 90���̻� A, 80���̻� B, 70�� �̻� C, 60�� �̻� D, 0�� �̻� F
 * 100���̻� ���� ó��
 */
package ch04condition;

import java.util.Scanner;

public class FlowEx4grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score;
		String grade = "";
		
		// ������ �Է¹޴´�.
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է����ּ���: -->");
		// ������ ����Ѵ�.
		score = Integer.parseInt(scanner.nextLine());
		System.out.println("�Է��� ���� : "+score);
		// ������ ���Ѵ�. A ~ F
		if(score > 100) grade = "�������� ";
		else if(score >= 90 ) grade = "A";
		else if(score >= 80 ) grade = "B";
		else if(score >= 70 ) grade = "C";
		else if(score >= 60 ) grade = "D"; 
		else if(score >= 0 ) grade = "F";
		else grade = "����";
		
		// ������ 0���� �۰ų� 100���� ũ�� ���� �Է� ������ ó��
		
		//������ ����Ѵ�.
		System.out.println("����� ������"+ grade +"�Դϴ�.");
		
		scanner.close();
	}

}
