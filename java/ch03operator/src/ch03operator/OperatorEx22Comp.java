package ch03operator;

public class OperatorEx22Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ��
		int a = 10;
		int b = 5;
		System.out.println(a>b);
		System.out.println(!(a>b));
		
		char ca = 'A';
		char cb = 'B';
		System.out.println(ca > cb);
		System.out.println(ca < cb);
		b = 10;
		
		// ���ڿ� ��
		String str1 = "abcd";
		String str2 = "abcd";
		String str3 = new String ("abcd");
		String str4 = new String ("abcd");
		System.out.println("str1 == str2 : "+ (str1 == str2));
		System.out.println(str3);
		// string�� ������ �����̱� ������ �ּҸ� ������ �ִ�. String�� ==�� ���ϸ� �ȵȴ�.
		System.out.println("str1 == str3 : "+ (str1 == str3));
		
		// str1~ str4������ �ּҸ� ����ϴ� ���α׷� �ۼ�
		// Hash code ���
		System.out.println("String Ŭ������ hash code ��� =============");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		// IdentityHashcode ���
		System.out.println("System Ŭ������ hash code ��� =============");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));		
		
		// ���ڿ� String�� ������ �񱳸� �� ���� equals() �޼��带 ����Ѵ�.
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		System.out.println(str3.equals(str4));
		}

}
