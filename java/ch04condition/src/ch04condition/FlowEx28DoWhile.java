/*
 * ���ڸ� ������ ���α׷�
 * �����ϰ� 1~100 ������ ���ڸ� ��ǻ�Ϳ��� �޾ƿ´�. ���ڸ� �Է��ؼ� ������.
 */
package ch04condition;

import java.util.Scanner;

public class FlowEx28DoWhile {

	public static void main(String[] args) {
		
		// 1 ~ 100 ������ ���� ���ڸ� ��ǻ�Ϳ��� �޾ƿ´�.
		// input : ����ڰ� �Է��� ����
		// answer : ���� = ��ǻ�Ͱ� �߻���Ų ���� ����
		int input = 0, answer = 0;
		
		// Math.random() - 0.0 < r < 1.0
		// (int )Math.random()*100 - 0.0 < r < 100.0 -> 0<r<100
		answer = (int)(Math.random() * 100)+ 1; // ������ �޾ƿԴ�.
		System.out.println(answer);
//		for(int i = 0,j = 1;;)
		// �����͸� �Է¹޴� ��ü ����
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ���ߴ� ����!");
		// ������ ������ �ݺ� - ���� �� ���� �ݺ��Ѵ�.
		do {
			System.out.println("1~100������ ���ڸ� �Է��ϼ���");
			input = Integer.parseInt(scanner.nextLine());
			if(input > answer)
				System.out.println("�� ���� ���� �õ��� ������.");
			else if (input < answer)
				System.out.println("�� ū ���� �õ��� ������.");
		}while(input != answer);// ������ �ƴϸ� ��� �ݺ���Ų��.
		
		//while ���� ���� ���� �� ó�� -> ������ ������.
		System.out.println("�����Դϴ�.");
		// �����͸� �Է� �޴� ��ü�� �ڿ��� ��ȯ�Ѵ�.
		scanner.close();
	}

}
