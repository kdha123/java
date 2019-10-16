/*
 * ����Լ�
 */
package ch06object;

public class FactorialTest {

	public static void main(String[] args) {
		
		// factorial() ������ �ʴ´�.
		int result = factorial(5);
		System.out.println(result);
		result = FactorialTest.factorial(5); //Ŭ���� �޼���
		System.out.println(result);
		
		FactorialTest f = new FactorialTest();
		result = f.factorial2(5); // �ν��Ͻ� �޼���
		System.out.println(result);
	}
	// static ���� - ���� �޸𸮿� �ڵ����� �ö󰣴�. - main()�� ����Ǵ� �������� �����Ѵ�.
	public static  int factorial(int n) {
		int result;
		if(n == 1)
			result = 1;
		else
			result = n * factorial(n-1);
		
		return result;
	}
	// non static�� ��� ���� �ּ� - ���� �޸𸮿� �ø����� new Ű���带 ����ؾ��Ѵ�.
	public int factorial2(int n) {
		return (n == 1) ? 1 : n * factorial2(n-1);
	}
}
