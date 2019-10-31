/*
 * ó�� �����ϴ�  main �κ� : PL�� �ۼ��ؼ� �־�д�.
 * ������ ��� ��Ʈ�ѷ����� ����� �޼��带 �����س��� �������̽��� �����.
 * ������ ��� ��Ʈ�ѷ��� �ۼ��� ���� �ݵ�� �������̽��� ��ӹ޾Ƽ� �������Ѵٰ� �����Ѵ�.
 * �޴�������
 * [main]
 * 1. ��������
 * 2. �Խ���
 * 3. �̹���
 * 4. �����亯
 * 5. �޼���
 * 6. ȸ������
 * 0. ����
 * 
 */
package com.webjjang.main;

import java.util.Scanner;

import com.webjjang.board.controller.BoardController;
import com.webjjang.notice.controller.NoticeController;

public class SwitchMain {

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
			switch (menu) {
			case "1":
				System.out.println("���û���ó��");
				// ��ü ���� - main memory�� �ø���. : new
				NoticeController noticeController = new NoticeController();
				// ������ ��ü�� ó������ ��� �ִ� �޼��带 ȣ���ؼ� ó���ϵ��� ��Ų��.
				noticeController.execute();
				// switch ���� ���� ������.
				// break : switch, for, while ���� ���������� ����Ѵ�.
				// break�� ���� ���� case�� �´� ���̶� case �Ʒ��� ó���ϱ� ���� ������
				// �� �Ʒ��� case�� ������� ó������ ó���ϰ� �ȴ�.
				break;
			case "2":
				System.out.println("�Խ���ó��");
				BoardController BoardController = new BoardController();
				BoardController.execute();
				break;
			case "3":
				System.out.println("�̹���ó��");
				break;
			case "4":
				System.out.println("�����亯ó��");
				break;
			case "5":
				System.out.println("�޼���ó��");
				break;
			case "6":
				System.out.println("ȸ������ó��");
				break;
			case "0":
				System.out.println("����ó��");
				// �ý��� ���� - 0:�������� - ���������� ���ᰡ �̷�����.
				System.exit(0);

			default:
				System.out.println("�߸��� �޴��� �Է��ϼ̽��ϴ�. \n �ٽ� �Է��� �ּ���.");
				break;
			}
		}
	}

}
