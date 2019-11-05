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
		while(true) {
			try {Thread.sleep(100);}catch (Exception e) {}
			// 밑에 생성한 Customer의 쓰레드의 이름을 가져와서 name에 넣고 테이블에 있는 음식을 지운 후 먹는다고 출력한다.
			String name = Thread.currentThread().getName();
			
			table.remove(food);
			System.out.println(name + " ate a "+ food);
			
		}// end of while
	}// end of run
}// end of customer class

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {this.table = table; }
	public void run() {
		while(true) {
			// 테이블의 dishNames의 길이를 인덱스로 가져와서 랜덤으로 하나 뿌리고 테이블에 추가한다.
			int idx = (int) (Math.random()*table.dishNum());
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
		// 최대 6개 까지 요리를 내놓을 수 있고 6개가 되면 요리사는 기다린다.
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting. ");
			try {
				wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		// 추가한 요리를 배열로 만든 dishes에 담고 출력한다.
		dishes.add(dish);
		notify();
		System.out.println("Dishes: " + dishes.toString());
	}
	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			
			while(dishes.size()==0) {
				System.out.println(name + " is waiting.");
				try {
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			while(true) {
				//손님이 원하는 메뉴와 요리사가 테이블에 내놓은 요리이름이 같다면 배열에서 0번째를 지우고 리턴한다.
				for(int i = 0; i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				}// end of for
				try {
					System.out.println(name+" is waiting.");
					wait();
					Thread.sleep(500);
				} catch (Exception e) {}
			}// end of while(true)
		}//end of synchronized
	}// end of remove
	public int dishNum() {return dishNames.length;}
}// end of table


public class ThreadWaitEx3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		Thread.sleep(2000);
		System.exit(0);
	}

}
