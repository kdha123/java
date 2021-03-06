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
		
		// 연산 시에 형변환
		resi = a + b;
		System.out.println(resi);
		ress = (short) (a + b);
		// short + short -> int : 하드웨어적으로 구조가 정해져있어서
		ress = (short) (sa + sb);
		// 큰 크기의 데이터에 맞춰서 연산이 된다.
		// long + int -> long -> long
		resi = (int) (la + a);
		System.out.println(da);
		System.out.println(da + b);
		a = (int) (da + b);
		System.out.println(a);
		System.out.println(ress);
		
		// /(나눗셈) - 소수점이 생기는 경우가 많다. = java에서는 int 연산 시 소수점 아래는 버린다.
		System.out.println(a / b); // 14/4 -> 3.5 -> 3;
		// 만약에 소숫점이 필요한 연산인 경우 한개 라고 데이터를 소숫점이 있는 데이터로 변환해준다.
		System.out.println((double)a / b);
//		System.out.println(a/0);
		System.out.println(a % b);// 2
	}

}
