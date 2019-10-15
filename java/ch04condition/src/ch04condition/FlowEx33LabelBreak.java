package ch04condition;

public class FlowEx33LabelBreak {

	public static void main(String[] args) {
//		Loop1 : //라벨(:)을 붙여서 이동할 때 사용한다. -> switch(case 값 : ~~)
		//break : switch, for, while - 제일 가깝게 감싸고 있는 한개
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j<=9; j++) {
				// 구구단을 완전 종료 조건
//				if(j==5) break Loop1;
				if(j==5) continue; // j가 5이면 아래 출력을 하지않고 반복문의 처음으로 간다.
				System.out.println(i +" * "+ j + " = " +(i * j));
			} // end of for j
			System.out.println();
		}   // end of for i 
		System.out.println("구구단 처리 끝~~~~");
		}

}
