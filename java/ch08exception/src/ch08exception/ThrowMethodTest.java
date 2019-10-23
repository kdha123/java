package ch08exception;

public class ThrowMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main 시작");
//		div(100,0);
		
		try {
			div2(100,0);
			// 오류가 난 경우는 아래 출력이 되면 안된다.
			System.out.println("main 끝");
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
			System.out.println("오류");
		}
		System.out.println("div() 끝");
	}
	public static void div2(int a, int b) throws Exception{
		System.out.println(a / b);}
	}

