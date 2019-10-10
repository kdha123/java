// package : Ŭ������ ��ġ�ϴ� ��ġ ������ �����Ѵ�.
package ch02valiable;


// public : ������ - �ܺ�(�ٸ���ġ:package)���� ���ٰ��� 
public class ValiableClass {
	// static : �ּҰ� ������ - ������ ����(�߰��� �����ؼ� �����ؼ� ���� ���)�� ������� �ʴ´�.
	//			Class�̸�.main()�� ����Ѵ�. ValiableClass.main()
	// void : ����. - method �տ� �ٿ��� ���
	// main() : ()�� ������ ó������ ����(�տ� ����Ÿ���� ���´�.)�� ���� method, ������Ʈ�� ���ۺκ��� ����
	// String : ���ڿ� = ���ڹ迭 = �������� ����(char) : ������ ����
	// [] :  �迭 => String[] : String(���ڿ�)�� ������
	// args : ����
	// {} : 0�� �̻� �������� ����
	public static void main(String[] args) {
		
		byte b = 123; // 1byte
		short s = 123; // 2byte
		// ū ������ Ÿ�Կ��� ���� ������ Ÿ������ �����͸� �̵���ų�� ū ������ Ÿ�Կ� ����ִ� �����Ͱ�
		// ���ǵ� �� ������ ���������� Ÿ���� �����ִ� �۾��� ���ִ� �� -> ĳ����(casting)
		// ĳ������ ���� ����� ���� ���� �������� �ʴ�.
		int i = (int) 123L; // 4byte - �⺻
		long l = 123L; // 8byte
		
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		
		// �ڵ� ĳ���� �׽�Ʈ
		// ���� ������ Ÿ��-> ū ����
		s = b;
		i = b;
		l = b;
		
		// ū ������ Ÿ�� -> ���� ����(������ ĳ���� �����ؼ� ��� : ������ ������ ���� �� �ִ�.)
//	    b = i;
		b = (byte) i; // ���� ĳ���� ����
		// int ���� ���� Ÿ���� �����͸� ������ �ϸ� CPU�� ���µ� CPU���� �����ϴ� ��ġ��
		// 4����Ʈ�̴�. �׷��� ����� int�� ���´�. int(4) -> short(2) : ĳ���� �ʿ�
		s = (short) (b + b);
		
		// final -> ��: ���� �Ұ��� --> ����, �޼ҵ�(ó���ϴ� ������), Ŭ����(������Ҹ�)
		final int fi;
		fi = 10; // �ʱ�(��ó��) ���� ���� �� �ִ�.
		System.out.println(fi);
//		fi = 20; // ������ �Ұ����ϴ�. -> ���(�������)
		// char - 2byte : �����Ѱ�: ���ڷ� �: ���� �������� �ʴ´�.
		char c = 'A';
		System.out.println(c); // A ���
		System.out.println((int)c); // 65���
		System.out.println(c+1); // 66���
		System.out.println((int)c+1); //66���
		System.out.println((char)(c+1)); // B���
		
		c = (char) i; // i type�� 4����Ʈ -> char 2����Ʈ  : ĳ���� �ʿ�
		i = c;
		c = (char) s; // s type 2����Ʈ -> c 2����Ʈ :ĳ���� �ʿ� 
		s = (short) c;
		
	}
}