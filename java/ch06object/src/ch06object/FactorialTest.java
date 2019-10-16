/*
 * 재귀함수
 */
package ch06object;

public class FactorialTest {

	public static void main(String[] args) {
		
		// factorial() 보이지 않는다.
		int result = factorial(5);
		System.out.println(result);
		result = FactorialTest.factorial(5); //클래스 메서드
		System.out.println(result);
		
		FactorialTest f = new FactorialTest();
		result = f.factorial2(5); // 인스턴스 메서드
		System.out.println(result);
	}
	// static 고정 - 메인 메모리에 자동으로 올라간다. - main()가 실행되는 시점에서 존재한다.
	public static  int factorial(int n) {
		int result;
		if(n == 1)
			result = 1;
		else
			result = n * factorial(n-1);
		
		return result;
	}
	// non static인 경우 가변 주소 - 메인 메모리에 올리려면 new 키워드를 사용해야한다.
	public int factorial2(int n) {
		return (n == 1) ? 1 : n * factorial2(n-1);
	}
}
