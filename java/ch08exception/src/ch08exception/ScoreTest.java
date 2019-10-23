package ch08exception;

import java.util.Scanner;

public class ScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 점수 입력
		Scanner scanner  = new Scanner(System.in);
		int score = 0;
		try {
			System.out.println("점수입력 : ");
			// jvm이 숫자가 아닌 다른 문자를 입력한 경우 NumberFormatException을 생성하고 던진다.
			// catch 중에서 NumberFormatException 받는 쪽으로 이동
		score = Integer.parseInt(scanner.nextLine());
		
		// 점수는 0~100사이 이기 때문에 0보다 작거나 100보다 크면 예외처리한다.
		if(score<0 || score>100)
			throw new OutOfScoreBoundaryException();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			scanner.close();			
		}
//		} catch (NumberFormatException e) {
//			System.out.println("숫자가 아닌 문자가 입력되었습니다.");
//		} catch (OutOfScoreBoundaryException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
	}

}
