package ch03operator;

public class OperatorEx22Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 숫자 비교
		int a = 10;
		int b = 5;
		System.out.println(a>b);
		System.out.println(!(a>b));
		
		char ca = 'A';
		char cb = 'B';
		System.out.println(ca > cb);
		System.out.println(ca < cb);
		b = 10;
		
		// 문자열 비교
		String str1 = "abcd";
		String str2 = "abcd";
		String str3 = new String ("abcd");
		String str4 = new String ("abcd");
		System.out.println("str1 == str2 : "+ (str1 == str2));
		System.out.println(str3);
		// string은 참조형 변수이기 때문에 주소를 가지고 있다. String은 ==로 비교하면 안된다.
		System.out.println("str1 == str3 : "+ (str1 == str3));
		
		// str1~ str4까지의 주소를 출력하는 프로그램 작성
		// Hash code 출력
		System.out.println("String 클래스의 hash code 출력 =============");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		// IdentityHashcode 출력
		System.out.println("System 클래스의 hash code 출력 =============");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));		
		
		// 문자열 String을 데이터 비교를 할 때는 equals() 메서드를 사용한다.
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		System.out.println(str3.equals(str4));
		}

}
