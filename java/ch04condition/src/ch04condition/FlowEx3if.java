/*
 * ������ �Է� �޾Ƽ� �հ� ���θ� ����ϴ� ���α׷� 
 * 2019.10.10
 * �赿��
 */
package ch04condition;

import java.util.Scanner;

public class FlowEx3if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ������ �Է� �޴´�.
		// �ܼ�â�� �ڵ����� ������ �Ϸ��� ����� �ؾ߸��Ѵ�.
		// 60�� �̻��̸�  "�հ�" �׷��� ������ "���հ�"�� ����Ѵ�. ������ �Բ� ����Ѵ�."
		int x;
		//String str;
				
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է����ּ���: -->");
		//str = scanner.nextLine();		
		//x = Integer.parseInt(str);
		x = Integer.parseInt(scanner.nextLine());
				
		
		// ��ȿ�� ������ ���� ó��(0~100)
		if(x > 100)System.out.println("����:100���� �Ѿ���");
		else {
			if(x>=60)
				System.out.println(x+"������ �հ��Դϴ�.");
			else {
				if(x >= 0) System.out.println("���հ�");
				else System.out.println("����:0�� �̸��Դϴ�.");
			}
		}
		
		// ��ȿ�� ������ ���� ó��(0~100)
		// ���� ��ġ�� �ʾƾ��Ѵ�. ���ӵ� ������ ó���� ��
		if(x > 100)System.out.println("����:100���� �Ѿ���");
		else if(x>=60)System.out.println(x+"������ �հ��Դϴ�.");
		else if(x >= 0) System.out.println("���հ�");
		else System.out.println("����:0�� �̸��Դϴ�.");
		
		//scanner �ݱ�
		scanner.close();
	}

}