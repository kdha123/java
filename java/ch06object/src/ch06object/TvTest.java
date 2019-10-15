package ch06object;

public class TvTest {
	

	
	public static void main(String[] args) {
		 
		System.out.println("Main");
		//TV 필요하다. - 객체로 생성해서 사용한다.
		// == 인스턴스화 시킨다. -> 인스턴스가 생긴다. => 자기 자신을 객체로 만들어서 주소를 제공할 때
		TV tv = new TV();
		tv.color = "black";
		System.out.println(tv.color);
		
	}

}

class TV {
	// TV 정보를 저장하는 변수 - TV 클래스의 구성원(member 변수)
	//- 메서드 안에 들어가있지 않다. 전역변수
	// new 할 때 생성이 되고 처리할 때는 이미 존재하게 되어져 있다. 초기화가 반드시 되어야한다.(자동)
	String color;  // 기본값으로 null
	boolean power; // 꺼져있는지 켜져있는지의 상태를 저장하는 변수 // 기본값으로 false
	int channel; // 현재 시청중인 채널의 정보를 저장하는 변수 // 기본값으로 0
	
	void print() {
		System.out.println(color);
		// 메서드 안에 있는 변수는 사용하려면 반드시 초기화를 수동으로 시켜줘야한다.
		String menu = null;
		System.out.println(menu);
	}
}