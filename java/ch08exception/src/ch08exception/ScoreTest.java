package ch08exception;

import java.util.Scanner;

public class ScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� �Է�
		Scanner scanner  = new Scanner(System.in);
		int score = 0;
		try {
			System.out.println("�����Է� : ");
			// jvm�� ���ڰ� �ƴ� �ٸ� ���ڸ� �Է��� ��� NumberFormatException�� �����ϰ� ������.
			// catch �߿��� NumberFormatException �޴� ������ �̵�
		score = Integer.parseInt(scanner.nextLine());
		
		// ������ 0~100���� �̱� ������ 0���� �۰ų� 100���� ũ�� ����ó���Ѵ�.
		if(score<0 || score>100)
			throw new OutOfScoreBoundaryException();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			scanner.close();			
		}
//		} catch (NumberFormatException e) {
//			System.out.println("���ڰ� �ƴ� ���ڰ� �ԷµǾ����ϴ�.");
//		} catch (OutOfScoreBoundaryException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
	}

}
