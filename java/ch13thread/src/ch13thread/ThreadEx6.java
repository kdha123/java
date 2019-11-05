package ch13thread;

import javax.swing.JOptionPane;

public class ThreadEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread time = new ThreadEx6_1();
		// 데몬쓰레드로 만들어서 main()가 끝나면 자동으로 끝내도록 처리한다.
		time.setDaemon(true);
		time.start();
		
		// 자바 창을 열어서 문제를 푸는 프로그램 작성
		// 자바 창 GUI 패키지 - awt, swing
		String input = JOptionPane.showInputDialog("402호 학생 이름은?");
		if(input.equals("김동현"))System.out.println("정답입니다.");
		else System.out.println("오답입니다.");
		// stop() -> 지양한다. 버전업하면서 다른메서드 사용하도록한다.
//		time.stop();
	}// end of main()

}// end of ThreadEx6 class

// 시간을 디스카운트하는 프로그램 작성
class ThreadEx6_1 extends Thread{

	// 요구되어 지는 run method
	@Override
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println("남은시간  :"+ i);
			try {
				// 1초동안 재운다.
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}