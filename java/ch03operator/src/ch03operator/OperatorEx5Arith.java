package ch03operator;

public class OperatorEx5Arith {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 4;
		int resi;
		short ress;
		short sa = 10;
		short sb = 4;
		long la = 10;
		double da = 10;
		
		System.out.println(a + " + " + b + " = "+ a + b);
		System.out.println(a + " + " + b + " = "+ (a+b));
		System.out.printf( "%d + %d = %d%n ",a,b,a+b);
		
		// ���� �ÿ� ����ȯ
		resi = a + b;
		System.out.println(resi);
		ress = (short) (a + b);
		// short + short -> int : �ϵ���������� ������ �������־
		ress = (short) (sa + sb);
		// ū ũ���� �����Ϳ� ���缭 ������ �ȴ�.
		// long + int -> long -> long
		resi = (int) (la + a);
		System.out.println(da);
		System.out.println(da + b);
		a = (int) (da + b);
		System.out.println(a);
		System.out.println(ress);
		
		// /(������) - �Ҽ����� ����� ��찡 ����. = java������ int ���� �� �Ҽ��� �Ʒ��� ������.
		System.out.println(a / b); // 14/4 -> 3.5 -> 3;
		// ���࿡ �Ҽ����� �ʿ��� ������ ��� �Ѱ� ��� �����͸� �Ҽ����� �ִ� �����ͷ� ��ȯ���ش�.
		System.out.println((double)a / b);
//		System.out.println(a/0);
		System.out.println(a % b);// 2
	}

}