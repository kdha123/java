/*
 * �޴�������
 * [main]
 * 1. ��������
 * 2. �Խ���
 * 3. �̹���
 * 4. �����亯
 * 5. �޼���
 * 6. ȸ������
 * 0. ����
 */
package com.webjjang.main;

import java.util.Scanner;

public class Main {

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ������ ���� �ݺ� ó�� - 0�� �Է��ϸ� �����Ų��.
		while(true) {
			// ���θ޴� ���
			System.out.println("1.�������� 2.�Խ��� 3.�̹���");
			System.out.println("4.�����亯 5.�޼��� 6.ȸ������");
			System.out.println("0.����");
			// ���θ޴� ��ȣ ����
			System.out.println("�޴��� ��ȣ�� �Է��ϼ���");
			String menu = scanner.nextLine();
			// ���� �޴� ó��
			if(menu.equals("1"))
				System.out.println("���û���ó��");
			else if(menu.equals("2"))
				System.out.println("�Խ���ó��");
			else if(menu.equals("3"))
				System.out.println("�̹���ó��");
			else if(menu.equals("4"))
				System.out.println("�����亯ó��");
			else if(menu.equals("5"))
				System.out.println("�޼���ó��");
			else if(menu.equals("6"))
				System.out.println("ȸ������ó��");
			else if(menu.equals("0")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				}
			else System.out.println("�߸��� �޴��� �Է��ϼ̽��ϴ�. \n �ٽ� �Է��� �ּ���.");
		}
	}

}
