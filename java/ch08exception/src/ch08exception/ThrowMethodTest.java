package ch08exception;

public class ThrowMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main ����");
//		div(100,0);
		
		try {
			div2(100,0);
			// ������ �� ���� �Ʒ� ����� �Ǹ� �ȵȴ�.
			System.out.println("main ��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void div(int a, int b) {
		try {
		System.out.println(a / b);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����");
		}
		System.out.println("div() ��");
	}
	public static void div2(int a, int b) throws Exception{
		System.out.println(a / b);}
	}

