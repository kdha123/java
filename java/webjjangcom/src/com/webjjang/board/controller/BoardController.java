/*
 * �Խ��Ǹ޴� 
 * [board]
 * 1. ����Ʈ
 * 2. ����
 * 3. ���
 * 4. ����
 * 5. ����
 * 0. �����޴�
 */
package com.webjjang.board.controller;

import java.util.Scanner;

public class BoardController {

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);
	
	// public ������ - main ��Ű���� Main Ŭ�������� ����Ѵ�.
	public void execute() {
		
		// �Խ����� ���� �ݺ� ó�� - 0�� �Է��ϸ� ���� �޴��� ����.(Main)
		while(true) {
			// �Խ��Ǹ޴� ���
			System.out.println("1.����Ʈ 2.���� 3.���");
			System.out.println("4.���� 5.���� 0.�����޴�");
			// ���θ޴� ��ȣ ����
			System.out.println("�޴��� ��ȣ�� �Է��ϼ���");
			String menu = scanner.nextLine();
			// ���� �޴� ó��
			switch (menu) {
			case "1":
				System.out.println("�Խ��� ����Ʈ ó��");
				// switch ���� ���� ������.
				// break : switch, for, while ���� ���������� ����Ѵ�.
				// break�� ���� ���� case�� �´� ���̶� case �Ʒ��� ó���ϱ� ���� ������
				// �� �Ʒ��� case�� ������� ó������ ó���ϰ� �ȴ�.
				break;
			case "2":
				System.out.println("�Խ��� ���� ó��");
				break;
			case "3":
				System.out.println("�Խ��� ��� ó��");
				break;
			case "4":
				System.out.println("�Խ��� ���� ó��");
				break;
			case "5":
				System.out.println("�Խ��� ���� ó��");
				break;
			case "0":
				return;

			default:
				System.out.println("�߸��� �޴��� �Է��ϼ̽��ϴ�. \n �ٽ� �Է��� �ּ���.");
				break;
			}
		}
	}

}
