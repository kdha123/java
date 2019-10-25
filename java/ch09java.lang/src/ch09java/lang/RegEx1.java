package ch09java.lang;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 숫자인지 확인하는 패턴
		//[] : 사이에 있는 것 중 하나.
		// + : 한개 이상
		Pattern numRegEx = Pattern.compile("^[0-9]+$");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 .");
		if(numRegEx.matcher(scanner.nextLine()).matches())
			System.out.println("입력하신 데이터는 숫자입니다.");
		else
			System.out.println("입력하신 데이터는 숫자가 아닙니다.");
		scanner.close();
		
		
		
	}

	
}
