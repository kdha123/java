/*
 * ���� ����� ����ϴ� ���α׷� �ۼ�
 * ������ : 1,250��
 * 65�� �̻� : 50%
 * 20��~64�� : ������
 * 14��~19�� : 70%
 * 7��~13�� : 50%
 * 0��~6�� : ����  
 * 10�������� ���� 100�� ������ ����ϴ� ó��
 */
package ch04condition;

import java.util.Scanner;

public class FlowExIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ������ ����
		int fee = 1250;
		
		// �����Է¹ޱ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է����ּ���: -->");
		int age = Integer.parseInt(scanner.nextLine());
		System.out.println("�Է��� ���� : "+age);
		
		//����� ��� 10���� ����
		int charge = (fee / 100) * 100 ;
		int charge2 = (fee / 100) * 50 ;
		int charge3 = (fee / 100) * 70 ;
		
		// ���
		if(age >= 65) System.out.println("������ "+(charge2)+"�� �Դϴ�.");
		else if(age >= 20) System.out.println("������ "+charge+"�� �Դϴ�.");
		else if(age >= 14) System.out.println("������ "+charge3+"�� �Դϴ�.");
		else if(age >= 7) System.out.println("������ "+charge2+"�� �Դϴ�.");
		else if(age >= 0) System.out.println("�����Դϴ�.");
		else if(age < 0)System.out.println("���̸� �ٽ� �Է����ּ��� ");;
		scanner.close();
	}

}
