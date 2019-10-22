package ch07object2;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		excute(new InterfaceImplFacFor());
		excute(new InterfaceImplFacRecall());
		excute(new InterfaceExcute() {
			// 익명클래스 작성 -> 한번만 처리하고 버린다. : AWT - 자바 창 객체-> 버튼처리
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("a를 실행");
			}
		});
		excute(new InterfaceExcute() {
			// 익명클래스 작성 -> 한번만 처리하고 버린다. : AWT - 자바 창 객체-> 버튼처리
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("b를 실행");
			}
		});
	}

	// 인터페이스를 받아서 실행하는 메서드
	// 실행하는 시간을 체크하는 프로그램
	// proxy program -> 바로 실행이 안되고 앞 뒤로 일정의 처리가 되고나서 중간에 처리되도록 만든 프로그램
	public static void excute(InterfaceExcute ie) {
		// 시간을 얻어오기
		long startTime = System.nanoTime();
		ie.excute();
		long endTime = System.nanoTime();
		System.out.println("소요시간 : "+ (endTime - startTime));
	}
}
