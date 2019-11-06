package ch13thread;

import java.util.ArrayList;

class Customer implements Runnable {
	private Table table;
	private String food;
	
	// Customer()는 테이블과 푸드를 가져오도록 만든다.
	Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}
	public void run() {
		// 음식이 나오면 처리문을 계속 진행해서 본인의 음식이면 먹는다.
		while(true) {
			// 약간의 딜레이 타임. 동작을 원활하게 하기 위해서
			try {Thread.sleep(100);}catch (Exception e) {}
			// 밑에 생성한 Customer의 쓰레드의 이름을 가져와서 name에 넣고 테이블에 있는 음식을 지운 후 먹는다고 출력한다.
			String name = Thread.currentThread().getName();
			// 음식을 먹는다.-> wait를 반복하다가 음식을 먹으면 notify를 한다.
			table.remove(food);
			System.out.println(name + " ate a "+ food);
			
		}// end of while
	}// end of run
}// end of customer class

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {this.table = table; }
	public void run() {
		// 테이블의 올려 놓은 음식이 최대 음식 개수 보다 적으면 음시을 만들어서 테이블에 올려 놓는다.
		while(true) {
			// 테이블의 dishNames의 길이를 인덱스로 가져와서 랜덤으로 하나 뿌리고 테이블에 추가한다.
			int idx = (int) (Math.random()*table.dishNum());
			// 음식을 만든다. -> table이 꽉차있으면 wait하다가 음식을 만들면 notify한다.
			table.add(table.dishNames[idx]);
			
			try {Thread.sleep(10);} catch (InterruptedException e) {}
		}//end of while(true)
	}// end of run()
}//end of Cook class


class Table{
	String[] dishNames = {"donut","donut","burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	// 위에서 요리사가 테이블에 추가한 요리를 동기화한다.
	public synchronized void add(String dish) {
		// 최대 6개 까지 요리를 내놓을 수 있고 6개가 되면 테이블이 꽉찼기 때문에 요리사는 기다린다.
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting. ");
			try {
				wait();// notify()에 의해서 깨어난다.
				Thread.sleep(500);// 깨어나면 0.5초를 기다린다.
			} catch (InterruptedException e) {}
		}
		// 추가한 요리를 배열로 만든 dishes에 담고 출력한다.
		dishes.add(dish);
		notify();// wait하고 있는 손님 쓰레드를 깨운다.
		// 현재 테이블에 있는 모든 음식 목록을 출력
		System.out.println("Dishes: " + dishes.toString());
	}
	// 손님이 음식을 먹어 치우는 메서드
	public void remove(String dishName) {
		// 동기화 블록 -> 한 손님이 먹고 있는 음식을 다른 손님이 먹지 못하도록 동기화 시킨다.
		synchronized (this) {
			// 손님 쓰레드 이름을 가져온다.
			String name = Thread.currentThread().getName();
			// 테이블에 만들어진 음식이 없으면 기다린다.
			while(dishes.size()==0) {
				System.out.println(name + " is waiting.");
				try {
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			// 테이블에 만들어진 음식이 있다.-> 내가 주문한 음식이 나와서 먹을 때까지 무한 루프
			while(true) {
				//손님이 원하는 메뉴와 요리사가 테이블에 내놓은 요리이름이 같다면 배열에서 0번째를 지우고 리턴한다.
				for(int i = 0; i<dishes.size();i++) {
					// 테이블에 있는 음식이 내가 주문한 음식인지 혹인한다.
					if(dishName.equals(dishes.get(i))) {
						// 손님이 음식을 먹는다.
						dishes.remove(i);
						// 다른 쓰레드에게 깨어나도록 처리(주방장이 포함되어있다.)
						notify();
						// 손님이 먹어치우는 메서드를 빠져나간다.
						return;
					}
				}// end of for -> 주문한 음식이 있는지 확인
				// 주문한 음식이 없는 경우 처리 -> 기다린다.(주방장이 음식을 확인다.)
				try {
					System.out.println(name+" is waiting.");
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}// end of while(true)
		}//end of synchronized
	}// end of remove
	public int dishNum() {return dishNames.length;}
}// end of table

// 여러개의 class가 있는 경우 public으로 작성할 수 있는 class는 파일이름과 동일한 클래스만 가능하다.
public class ThreadWaitEx3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 공통으로 사용하는 테이블 생성
		Table table = new Table();
		
		// 주방장 쓰레드
		new Thread(new Cook(table), "COOK1").start();
		// 손님 1쓰레드
		new Thread(new Customer(table, "donut"), "CUST1").start();
		// 손님 2 쓰레드
		new Thread(new Customer(table, "burger"), "CUST2").start();
		Thread.sleep(2000);
		System.exit(0);
	}

}
