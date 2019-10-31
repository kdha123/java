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

import java.util.List;
import java.util.Scanner;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.main.Controller;
import com.webjjang.view.BoardView;

public class BoardController implements Controller{

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);
	
	@Override
	// public ������ - main ��Ű���� Main Ŭ�������� ����Ѵ�.
	public void execute() {
		
		System.out.println("---------------");
		System.out.println("---- �Ϲ� �Խ��� ----");
		System.out.println("---------------");
		// �Խ����� ���� �ݺ� ó�� - 0�� �Է��ϸ� ���� �޴��� ����.(Main)
		while(true) {
			try {
			// �Խ��Ǹ޴� ���
			System.out.println();
			System.out.println("1.����Ʈ 2.���� 3.���");
			System.out.println("4.���� 5.���� 0.�����޴�");
			// ���θ޴� ��ȣ ����
			System.out.println("�޴��� ��ȣ�� �Է��ϼ���");
			String menu = scanner.nextLine();
			// ���� �޴� ó��
			switch (menu) {
			case "1":
				System.out.println("�Խ��� ����Ʈ ó��");
				// ��ü ���� : BoardController -> BoardListService 
				//                         -> BoardDAO
				BoardListService boardListService = new BoardListService();
				// ������ �������� -> �޼��� ȣ��
				List<BoardDTO> list = boardListService.service();
				// ������ �����͸� ���(��ü�� ���� ->�޼��� ȣ��)
				BoardView boardView = new BoardView();
				boardView.list(list);
				// try catch�� ������ �ѹ��� �� ���� �� �ְ� �ȴ�.
				break;
			case "2":
				System.out.println("�Խ��� ���� ó��");
				// list�� ���� �����Ͻð� �ִ� �۹�ȣ�� �����Ѵ�.
				System.out.println("������ �۹�ȣ�� �Է��ϼ���.");
				int no = Integer.parseInt(scanner.nextLine());
				BoardViewService boardViewService = new BoardViewService();
				// ������ ��������
				BoardDTO dto = boardViewService.service(no);
				// �����ϰ� ȣ��
				//������ ���(����->ȣ��)
				BoardView boardView2 = new BoardView();
				boardView2.view(dto);
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
				System.out.println("�����޴�.");
				return;

			default:
				System.out.println("�߸��� �޴��� �Է��ϼ̽��ϴ�. \n �ٽ� �Է��� �ּ���.");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// �����ڸ� ���� �ڵ�
			e.printStackTrace();
			//����ڸ� ���� �ڵ�
			System.out.println("�Խ����� ó���ϴ� �� ������ �߻��Ǿ����ϴ�.");
			System.out.println("��� �Ŀ� �ٽ� �õ��� �ּ���.");
			System.out.println("��� ������ �ȵǸ� �������� ���� ������ �ּ���.");
		}
	}
	}

}
