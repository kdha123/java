package ch04condition;

import java.util.Scanner;

public class FlowEx6Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �� �Է�
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ���� �Է����ּ���.");
		int month = Integer.parseInt(scanner.nextLine());
	
		//����ó��
		// switch = label(:) ������ �̿��ϰ� �ִ�. -> ������ ���ϴ� ��ġ�� �̵�
		switch (month) {
		case 3:
			System.out.println(3);
		case 4:
			System.out.println(4);
		case 5:
			System.out.println(5);
			System.out.println("��");
			break;
			
		case 6:
			System.out.println(6);
		case 7:
			System.out.println(7);
		case 8:
			System.out.println(8);
			System.out.println("����");
			break;
			
		case 9:
			System.out.println(9);
		case 10:
			System.out.println(10);
		case 11:
			System.out.println(11);
			System.out.println("����");
			break;

		case 12:
			System.out.println(12);
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
			System.out.println("�ܿ�");
			break;

		default:
			System.out.println("����");
			break;
		}
		scanner.close();
	}

}
