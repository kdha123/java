package ch04condition;

public class FlowEx23While {

	public static void main(String[] args) {
		int i = 1;
		
		i = 1;
		for(; i<=5;) {
			System.out.println(i++);	
		}
		
		
		// 조건에 따라서 반복처리
		i = 1;
		System.out.println("while문을 이용한 출력 =======");
		while(i<=5)
			System.out.println(i++);
		
		
		
		i = 1;
		for(;;) { //무한 반복 : while(true)와 동일
			if(!(i<=5)) break; // 반복처리 결정 조건 -> 반복문을 빠져나가는 조건
			System.out.println(i); //실제적인 처리문
			i++; // 증감값
			
		}
		
		i = 1;
		while(true) { 
			if(!(i<=5)) // 반복처리 결정 조건 -> 반복문을 빠져나가는 조건
				break; 
			System.out.println(i); //실제적인 처리문
			i++; // 증감값
		
			
		}
	}

}
