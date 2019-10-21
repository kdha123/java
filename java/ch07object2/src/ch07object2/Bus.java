package ch07object2;

// 추상메서드가 있는 추상클래스를 상속받으면 반드시 추상 메서드를 재정의(override) 해야한다. 
public class Bus extends Transport {

	@Override
	public void move() {
		System.out.println("버스로 이동");
		
	}

}
