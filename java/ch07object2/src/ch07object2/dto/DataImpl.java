package ch07object2.dto;

public class DataImpl extends Data{

	// 상속받은 변수는 다 내꺼다. -> 같은 패키지에서는 private은 제외
	
	public void print() {
		System.out.println(pubInt);
		System.out.println(proInt);
		System.out.println(defInt);
//		System.out.println(priInt); // private으로 선언한 것은 상속하지 않는다.
	}
}
