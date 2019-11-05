package ch13thread;

public class ThreadEx21 {

	public static void main(String[] args) {

		//		Thread t = new ThreadEx21_1();
		// ThreadEx21은 한번만 생성되도록 해서 같은 통장을 사용하도록 한 것.
		Runnable r = new ThreadEx21_1();
		//은행창구처리
		Thread t1 = new Thread(r);
		//ATM처리
		Thread t2 = new Thread(r);
		// 같은 통장에서 처리하도록 만들자.
		// 은행 창구에서 출금처리
		t1.start();
		// ATM에서 출금처리
		t2.start();


	}// end of main()

}//end of ThreadEx21 class

// 은행 잔고 객체 - 잔액, 출금 메서드
class Account {
	private int balance = 1000;

	//잔고를 확인하는 메서드
	public int getBalance() {return balance;}

	//출금하는 메서드 -> 동기화
	//	public synchronized void withdraw(int money) {
	public void withdraw(int money) {
		//잔액 출력
		System.out.println("if 전 잔액 : "+ balance);

		// 동기화 블록을 이용해서 동기화
		synchronized (this) {

			// 잔액이 찾는 금액보다 크거나 같아야 출금을 해준다.
			if(balance >= money) {
				try {Thread.sleep(1000);} catch (InterruptedException e){}
				System.out.println("if 안에서 잔액 : " + balance);
				balance -= money;
			}// end of if
		}// end of synchronized
	} // end of withdraw
}// end of Account class


// 돈을 찾아가는 쓰레드 정의 -> 은행창구를 이용 또는 자동화기기를 이용 -> new는 한번만
// -> Thread -> Runnable
class ThreadEx21_1 implements Runnable{
	Account acc = new Account();

	public void run() {
		// 잔액이 남아있는 경우만 처리
		while(acc.getBalance() > 0) {
			//100, 200, 300원을 랜덤으로 찾는다.
			int money = (int)(Math.random()* 3 + 1) * 100;
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+"인출금액 : "+money);
			// 돈을 찾는다.
			acc.withdraw(money);

			// 잔액을 출력한다.
			System.out.println(threadName + "balance : " + acc.getBalance());
		}// end of while
	}// end of run()
}// end of ThreadEx21_1 class