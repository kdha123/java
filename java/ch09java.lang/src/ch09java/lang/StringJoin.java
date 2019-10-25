package ch09java.lang;

import java.util.StringJoiner;

public class StringJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] interest = {"자바","오라클","웹프로그램","빅데이터","IoT"};
		// ","를 이용해서 하나의 문자열로 연결해서 만들기
		String interests = "";
		
		// 1번 방법
		for(String str : interest) {
			if(interests.equals("")) {
				interests = str;
			}
			interests = interests + ","+str;
		}
		System.out.println(interests);
			
		// 2번 방법
		interests = "";
		for(String str : interest)
			interests += str+",";
		interests = interests.substring(0, interests.length()-1);
		System.out.println(interests);
		
		// 3번 방법
		StringJoiner sj = new StringJoiner(",");
		for(String str : interest)
			sj.add(str);
		System.out.println(sj);
	
	}

}
