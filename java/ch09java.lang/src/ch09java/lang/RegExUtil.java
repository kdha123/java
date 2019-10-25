package ch09java.lang;

import java.util.regex.Pattern;

public class RegExUtil {

	// 데이터가 패턴에 일치하는지 알아내는 메서드 작성
	// data가 패턴에 맞으면 true가 리턴되고 맞지않으면 false가 리턴된다.
	public static boolean matchRegEx(String patternStr, String data) {
		return Pattern.compile(patternStr).matcher(data).matches();
		
	}
}
