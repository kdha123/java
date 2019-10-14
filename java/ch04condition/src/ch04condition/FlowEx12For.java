package ch04condition;

public class FlowEx12For {

	public static void main(String[] args) {
		
		// 1~5까지 출력하는 프로그램 작성 -> 데이터가 1부터 5까지 변한다. : 변수가 필요하다.
		
		//하드코딩은 다음과 같음
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
	    
		// 반복문 : 시작하는 값과 끝나는 값이 정해져 있고 증가되는 값이 일정하다. -> for문 사용
		// for(초기값; 반복 조건; 증감값){ 반복처리 }
		for(int i = 1; i <= 5; i++)
			System.out.println(i);

//		System.out.println(i); -- for안에서 선언된 변수는 밖에서 사용할 수 없다.
		int i = 1;
		for(;i<=5;i++)System.out.println(i);
		System.out.println("for 문 밖에서 출력된 i : "+ i);
		
		i = 1;
		for(; i<=5;) {
			System.out.println(i++);	
		}
		
		i=1;
		for(;;) { //무한 반복 : while(true)와 동일
			if(!(i<=5)) break; // 반복처리 결정 조건
			System.out.println(i); //실제적인 처리문
			i++; // 증감값
		}
	}

}
