package ch09java.lang;

public class StirngSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사용자에게 입력 받은 데이터
		int yy = 2019;
		int mm = 10;
		int dd = 25;
		
		//DB에는 형식 : 2019-10-25
		String birth = yy + "-" + mm + "-" + dd;
		System.out.println("생년월일 "+ birth);
		
		// DB에 있는 데이터를 to_char(birth, 'yyyy-mm-dd') birth
		// 사용자에게 수정을 시키기 위해서  년, 월, 일을 각각 분리해 낸다.
		String[] days = birth.split("-");
		
		// 각각의 날짜 요소에 해당되는 변수에 전달한다.
		yy = Integer.parseInt(days[0]);
		mm = Integer.parseInt(days[1]);
		dd = Integer.parseInt(days[2]);
		
		// 배열 한개씩 출력
		for(int i = 0; i < days.length; i++)
			System.out.println(days[i]);
		for(String d : days)
			System.out.println(d);
		
		System.out.println("연도 : "+ yy);
		System.out.println("월 : "+ mm);
		System.out.println("일 : "+ dd);
		
		// 생년월일의 문자길이 출력
		System.out.println("생년월일의 문자길이 : "+ birth.length());
		// 생년월일 문자열을 문자 하나씩 출력해보자.
		for(int i = 0; i < birth.length(); i++)
			System.out.println(birth.charAt(i));
		// 생년월일 문자열을 한 줄에 전부 출력해보자.
		for(int i = 0; i < birth.length(); i++)
			System.out.print(birth.charAt(i));
		System.out.println();
		
		// 관심사에 해당되는 데이터를 가져왔다. 자바, 빅데이터, 오라클, IoT, 모바일웹
		String interest1 = "자바, IoT, 모바일웹";
		String interest2 = "자바, 오라클";
		// 신청한 사람이 오라클에 관심이 있는지 알아내자.0
		System.out.println(interest1.indexOf("오라클"));
		System.out.println(interest2.indexOf("오라클"));
		if(interest1.indexOf("오라클") < 0)
			System.out.println("오라클에 관심이 없다.");
		else 
			System.out.println("오라클에 관심이 있다.");
		if(interest2.indexOf("오라클") < 0)
			System.out.println("오라클에 관심이 없다.");
		else 
			System.out.println("오라클에 관심이 있다.");
		
		//interest1 변수의 값 중 위치가 4~7 까지의 문자를 잘라내보자.
		System.out.println(interest1.substring(4,8));
		System.out.println(interest1.substring(4));
		
		// 맨 마지막에 있는 ","의 위치-> lastIndexOf
		System.out.println((interest1.substring(interest1.lastIndexOf(",")+1)).trim());
	
		
		String file = "c:/upload/image.pic/my.photo.jpg";
		String fullFileName = file.substring(file.lastIndexOf("/")+1);
		System.out.println(fullFileName);
		int pos = fullFileName.lastIndexOf(".");
//		String fileName = file.substring(20,28);
		String fileName = fullFileName.substring(0, pos);
		System.out.println(fileName);
		
		String ext = fullFileName.substring(pos+1);
		System.out.println(ext);
		
		// 
	}

}
