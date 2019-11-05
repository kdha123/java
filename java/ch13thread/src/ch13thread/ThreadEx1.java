package ch13thread;

public class ThreadEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Thread 생성 : Ex1_1, Ex1_2를 Thread로 생성한다.
		// 원래 Thread 객체 생성
		Thread t1 = new ThreadEx1_1();
		// Runnable을 Thread로 생성
		Thread t2 = new Thread(new ThreadEx1_2());
		
		//Thread 2개를 동시에 돌려보자.
		System.out.println("MultiThread의 시작");
		t1.start();
		t2.start();
		System.out.println("end of MultiThread");
		
	}//end of main method

}// end of ThreadEx1 class

// Thread로 처리할 클래스 작성 -> Thread class를 상속받아서 작성한다.
class ThreadEx1_1 extends Thread{
	
	//Thread를 돌리기 위한 특별한 메서드
	@Override
	public void run() {
		//1~5까지 출력하는 프로그램 작성
		for(int i= 1; i<=5; i++) {
			//Thread의 이름을 받아내서 출력
			System.out.println("ThreadEx1_1 : "+ getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}// end of ThreadEx1_1 class


// Thread로 처리할 클래스 작성 -> Runnable interface를 상속받아서 작성한다.
class ThreadEx1_2 implements Runnable{
	
	//Thread를 돌리기 위한 특별한 메서드
	@Override
	public void run() {
		//1~5까지 출력하는 프로그램 작성
		for(int i= 1; i<=5; i++) {
			// 자신의 돌고있는 Thread를 받아내서 이름을 출력한다.
			System.out.println("ThreadEx1_2 : "+ Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}// end of ThreadEx1_2 class