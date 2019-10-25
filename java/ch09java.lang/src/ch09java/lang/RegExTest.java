package ch09java.lang;

import java.util.Scanner;

import ch09java.lang.util.regex.RegEx;

public class RegExTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String numReg = "^[0-9]+$";
		String input = "123ads";
		if(RegExUtil.matchRegEx(numReg, input))
			System.out.println("숫자입니다.");
		else
			System.out.println("숫자가 아닙니다.");
		
		// 이메일인지 알아내는 패턴 문자열
		System.out.println("이메일을 입력해주세요");
		String inputEmail = scanner.nextLine();
		if(RegEx.matchRegEx(RegEx.emailReg, inputEmail))
			System.out.println("이메일이 맞습니다.");
		else 
			System.out.println(RegEx.emailErrorMsg);
				
		// 핸드폰 번호 인지 알아내는 패턴 문자열
		System.out.println("핸드폰번호를 입력해주세요");
		String inputPn = scanner.nextLine();
		if(RegEx.matchRegEx(RegEx.pnReg, inputPn))
			System.out.println("핸드폰 번호가  맞습니다.");
		else
			System.out.println(RegEx.pnErrorMsg);
	
		// 생년월일 인지 알아내는 패턴 문자열
		System.out.println("생년월일을 입력해주세요");
		String inputBirth = scanner.nextLine();
		if(RegEx.matchRegEx(RegEx.birthReg, inputBirth))
			System.out.println("생년월일이  맞습니다.");
		else
			System.out.println(RegEx.birthErrorMsg);
		
		// 아이디 - 맨 앞자리는 영문자이여야 한다. 그리고 뒤에는 영문자와 숫자만 사용 가능하다.
		//       길이가 4자부터 20자까지만 가능하다.
		System.out.println("아이디를 입력해주세요");
		String inputId = scanner.nextLine();
		if(RegEx.matchRegEx(RegEx.idReg, inputId))
			System.out.println("아이디가  맞습니다.");
		else
			System.out.println(RegEx.idErrorMsg);
		
		// 비밀번호 - 길이가 4자이상이고 아무 글자나 사용가능하다.
		System.out.println("비밀번호를 입력해주세요");
		String inputqw = scanner.nextLine();
		if(RegEx.matchRegEx(RegEx.pwReg, inputqw))
			System.out.println("비밀번호가  맞습니다.");
		else
			System.out.println(RegEx.pwErrorMsg);
		
		scanner.close();
	}
	}
