package ch07object2.dto2;

import ch07object2.dto.Data;

public class DataImpl extends Data{

	// 상속받은 변수는 다 내꺼다. -> 같은 패키지에서는 private은 제외
	
	public void print() {
		System.out.println(pubInt);
		System.out.println(proInt); // 다른 패키지이지만 상속해서 사용할 수 있다. new안됨
//		System.out.println(defInt); // 다른 패키지인 경우 상속, new 둘다 불가능
//		System.out.println(priInt); // private으로 선언한 것은 상속하지 않는다.
	}
}
