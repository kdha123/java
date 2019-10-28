package ch10date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//오늘 날짜 객체
		Date today = new Date();
		System.out.println(today);
		int yy = today.getYear();
		System.out.println(yy); //119 -> 컴퓨터의 시작일 : 0
		yy += 1900;
		System.out.println(yy);
		
		int mm = today.getMonth();
		System.out.println(++mm); // month는 0~11까지
		// 요일(getday) : 0~6까지 사용한다.
		
		int dd = today.getDate();
		System.out.println(dd);
		// 오늘 날짜 형식에 맞춰서 출력한다.
		System.out.println(yy + "-"+ mm + "-" + dd);
		
		// 날짜 형식을 만들어주는 객체 -> SimpleDateFormat
		// 타입을 날짜폼객체 생성하면 파라메터로 아무것도 전달하지 않으면 기본형식사용 
		// 기본형식 : yy. mm.dd  오전/오후 시:분
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(today));
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(today));
		
		// 오늘 날짜 셋팅 -> 날짜를 지정
		Date day1 = new Date(yy - 1900, mm-1,dd);
		System.out.println(sdf.format(day1));
		
		Date chriDate = new Date(today.getYear(), 11, 25);
		System.out.println(sdf.format(chriDate));
		
		Date day2 = new Date("10/28/2019");
		System.out.println(sdf.format(day2));
	}

}
