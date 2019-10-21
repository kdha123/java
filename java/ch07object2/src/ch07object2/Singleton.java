package ch07object2;

public class Singleton {

	// 프로그램 중에서 클래스이름이 발견이 되면 자동으로 올라가므로 생성을 해서 초기화시켜서 넣어둔다.
	// 그러나 가져가서 사용할 수 없다.
	private static Singleton singleton = new Singleton();
	
	// 외부에서 접근이 안되는 생성자를 만들었다. -> 같은 클래스에서만 생성할 수 있다.
	private Singleton() {
		// TODO Auto-generated constructor stub
		
	}
	// 외부에서는 생성할 수 없으나 가져가서 사용할 수 있도록 public getInstance()메서드를 만든다.
	// new할 수 없으므로 static으로 정의한다. Singleton.getInstance();
	public static Singleton getInstance() {
		return singleton;
	}
	// 실행하려는 메서드들
	public void print() {
		System.out.println("Singleton.print()");
	}
}
