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
		int fee = 1250;
		int age;
		// �����Է¹ޱ�
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է����ּ���: -->");
		age = Integer.parseInt(scanner.nextLine());
		System.out.println("�Է��� ���� : "+age);
		

		int charge = (fee / 100) *100 ;
		int charge2 = (fee / 100) *50 ;
		int charge3 = (fee / 100) *70 ;
		
		if(age <= 6) System.out.println("�����Դϴ�.");
		else if(age >= 7 && age <= 13) System.out.println("������"+charge2+"�� �Դϴ�.");
		else if(age >= 14 && age <= 19) System.out.println("������"+charge3+"�� �Դϴ�.");
		else if(age >= 20 && age <= 64) System.out.println("������"+charge3+"�� �Դϴ�.");
		else if(age >= 65) System.out.println("������"+(charge2)+"�� �Դϴ�.");
		
		scanner.close();
	}

}