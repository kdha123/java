package ch07object2;

public interface InterfaceDefault {

	// 기본 메서드 - 자바8 이상이어야 가능하다. -> 반드시 재정의하지 않아도 된다.
	default public  void execute() {
		System.out.println("default");
	}
}
