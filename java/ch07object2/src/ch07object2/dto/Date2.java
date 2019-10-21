package ch07object2.dto;

public class Date2 {

	public void print() {
		// Data 생성 -> 같은 패키지에 있는 클래스를 생성;
		Data data = new Data();
		data.pubInt = 100;
		data.proInt = 100;
		data.defInt = 100;
//		data.priInt = 100; // private은 같은 클래스에서 사용 가능합니다.
	}
}
