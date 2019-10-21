package ch07object2;

// 추상 메서드를 가지고 있는 클래스-> 추상클래스라고 한다. -> 독자적으로 생성이 안됨.
// 생성을 할 순 있으나 추상메서드를 해결해야한다.
public abstract class Transport {
	
	public String name = "김동현";
	
	// 일반메서드 구현가능
	public int pay() {return 100;}
	
	// 이동하는 수단 메서드 -> 무엇을 타고갈지 결정이 안됐다.
	public abstract void move();//{}없다. 구현 안함. -> 추상메서드
}
