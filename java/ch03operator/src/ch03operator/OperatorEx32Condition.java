package ch03operator;

import java.util.Scanner;

public class OperatorEx32Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� �־ ó���� ���� ����
		int x;
		String str;
		
		// ���� Ű����� �Է��� �޴´�.
		// ���ڿ��� ����� str�� ���� int�� ��ȯ
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �Է����ּ���: -->");
		str = scanner.nextLine();
		x = Integer.parseInt(str);
		
		// �Էµ� ���� ���밪�� ���Ѵ�. -���� +������ ��ȯ��Ų��. ex) -5 -> +5
		// if(����: -��)-x
		// if(x < 0)x = -x;
		// ���� ? true�� : false�϶� ��
		x = (x < 0) ? -x : x;
		
		//���� ����Ѵ�.
		System.out.println(str);
		System.out.println(x);
		
		//scanner �ݱ�
		scanner.close();
	}

}