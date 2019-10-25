package ch09java.lang.util.regex;

import java.util.regex.Pattern;


public class RegEx {

	//사용하는 데이터의 정규표현문자열 -> 밖에서 가져다가 사용하는 변수
	public static final String emailReg = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	public static final String emailErrorMsg = "데이터가 이메일 패턴이 아닙니다.\n이메일은 맨앞에 영문자로 시작하고 중간에 '@'이 들어가야합니다.";
	
	public static final String pnReg = "^01([0|1|6|7|8|9]?)-?([0-9]{4})-?([0-9]{4})$";
	public static final String pnErrorMsg = "데이터가 휴대폰 번호 패턴이 아닙니다. \n휴대폰 번호는 01(1~9)-4자리숫자-4자리숫자입니다.";
	
	public static final String birthReg = "^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
	public static final String birthErrorMsg = "데이터가 생년월일 패턴이 아닙니다.\n yyyy-mm-dd로 입력해주세요.";
	
	public static final String idReg = "^[a-zA-Z]{1}[a-zA-Z0-9]{4,20}$";
	public static final String idErrorMsg = "데이터가 아이디 패턴이 아닙니다.\n맨 앞자리는 영문자이고 뒤에는 영문자와 숫자로 4~20자리로 해주세요";
	
	public static final String pwReg = "^.{4,20}$";
	public static final String pwErrorMsg = "데이터가 비밀번호 패턴이 아닙니다.\n 최소 4자이상 아무거나 입력해주세요.";
	
	// 데이터가 패턴에 일치하는지 알아내는 메서드 작성
	// data가 패턴에 맞으면 true가 리턴되고 맞지않으면 false가 리턴된다.
	public static boolean matchRegEx(String patternStr, String data) {
		return Pattern.compile(patternStr).matcher(data).matches();
}
}