// 클래스의 위치 파일이 있는 폴더 확인해서 작성
package ch03operator;

// 클래스 선언 - 파일명을 확인해서 작성
public class OperatorEx1SingleOp{
	// 자동적으로 인식해서 실행이되는 메서드 main() 작성
	public static void main(String[] args) {
		// i 변수 선언 후에 초기값 셋팅
		int i = 5;
		System.out.println("i = " + i);
		// i 변수에 1증가 시키자.
		i = i + 1; // 6
		System.out.println("i = " + i);
		i += 1; // 7
		System.out.println("i = " + i);
		++i; // ++i : 선 증가 후 처리 , 8
             // 단독으로 증가문만 사용할때는 선 증가나 후 증가가 상관이 없다.		
		System.out.println("i = " + i);
		i++; // i++ : 선 처리 후 증가, 9
		System.out.println("i = " + i); 
		System.out.println("i = " + ++i +"// i = "+ ++i);// 10 11
		System.out.println("i = " + i++ +"// i = "+ i++);// 11 12
		System.out.println("i = " + i); // 13
		// 1증가 - 출력 전에 처리
		i++; //14
		// 출력
		System.out.println("i = " + i);
		// 위에 2줄을 한 줄로 만들 수 있다.
		System.out.println("i = " + ++i); //15
		
		//출력 - 증가하기 전에 출력
		System.out.println("i = " + i); //15
		// 1증가 - 출력 후에 처리
		i++; //16
		// 출력
		// 위에 2줄을 한 줄로 만들 수 있다.
		System.out.println("i = " + i++);//16
	}
}