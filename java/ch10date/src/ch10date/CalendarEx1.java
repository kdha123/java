package ch10date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarEx1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar today = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar -> data : getTime()
		System.out.println(sdf.format(today.getTime()));
		// 년에 해당되는 필드번호를 이용해서 년도를 가져온다. 1-> Calendar.YEAR
		int yy = today.get(1);
//		System.out.println(Calendar.YEAR);
		System.out.println(Calendar.YEAR);
		System.out.println(yy);
		int mm = today.get(Calendar.MONTH);
		System.out.println(mm+1);
		int dd = today.get(Calendar.DATE);
		System.out.println(dd);
		
		// SimpleDateFormat을 이용해서 형식을 만들어서 날짜 출력
		// 전달해야할 파라메터 갑을 Date 객체와 같은 것이여야 한다.
		// Calendar 객체 -> Date 객체로 변화하는 메서드 : getTime()
		System.out.println(sdf.format(today.getTime()));
		 
		// Date 객체 -> Calendar 객체
		today = Calendar.getInstance();
		today.setTime(new Date("12/25/2019"));
		System.out.println(sdf.format(today.getTime()));
	}

}
