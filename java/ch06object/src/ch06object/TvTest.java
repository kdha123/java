package ch06object;

public class TvTest {
	

	
public static void main(String[] args) {
		 
	System.out.println("Main");
	//TV 필요하다. - 객체로 생성해서 사용한다.
	// == 인스턴스화 시킨다. -> 인스턴스가 생긴다. => 자기 자신을 객체로 만들어서 주소를 제공할 때
	TV tv1 = new TV();
	TV tv2 = new TV();
	System.out.println(tv1.toString() + "/"+tv2);
	tv1.color = "black";
	System.out.println(tv1.color);
		
	// tv1 객체의 기능을 사용해보자.
	// 전원 조작
	tv1.powerOnOff();
	System.out.println(tv1);
	
	//채널 올리기
	tv1.channelUp();
	System.out.println(tv1);
	
	//채널내리기
	tv1.channelDown();
	System.out.println(tv1);
	
	//채널변경
	tv1.channelChange(11);
	System.out.println(tv1);
	
	
	// 모든 클래스는 기본적으로 Object를 상속받는다.
	// Object(부모클래스) - TV(자식클래스:Object가 가지고 있는 것을 상속 받는다.)
	// 중요 : 관계가 생겼다. -> 캐스팅(형변환)이 가능하다.
	// TV - Object로 만드는데는 문제가 없다.
	// Object -> TV로 캐스팅할 때는 문제가 있다. Object타입에 TV객체를 저장해놓은 경우만 가능
	Object obj = new TV(); // 작 -> 큰 : 자동 캐스팅
	System.out.println(obj.toString());
	((TV)obj).channelUp();
	System.out.println(obj);
	
	// Object 안에 넣은 것이 String -> Object[String]
	obj = new String("test");
//	((TV)obj).channelUp(); // TV와 String은 서로 캐스팅할 수 없기 때문에 오류 
	System.out.println(obj);
	
	
	} // end of main()

}// end of TvTest class

// 클래스 선언
class TV {
	// TV 정보를 저장하는 변수 - TV 클래스의 구성원(member 변수)
	//- 메서드 안에 들어가있지 않다. 전역변수
	// new 할 때 생성이 되고 처리할 때는 이미 존재하게 되어져 있다. 초기화가 반드시 되어야한다.(자동)
	String color;  // 기본값으로 null
	boolean power; // 꺼져있는지 켜져있는지의 상태를 저장하는 변수 // 기본값으로 false
	int channel; // 현재 시청중인 채널의 정보를 저장하는 변수 // 기본값으로 0
	
	// 생성자 - 생성할 때 호출해서 사용하는 특별한 메서드 , javac가 생성자가 없으면 자동적으로 만든다.
	public TV() {} 
	
	
	void print() {
		System.out.println(color);
		// 메서드 안에 있는 변수는 사용하려면 반드시 초기화를 수동으로 시켜줘야한다.
		String menu = null;
		System.out.println(menu);
	} // end of print()
	
	// 전원켜기 끄기 : true -> false, false -> true(not : !)
	void powerOnOff() {	power = !power;}// ! : not	
	// 채널 올리기
	void channelUp() { channel++;}
	// 채널 내리기
	void channelDown() { channel--;}
	// 채널 선택-> 번호를 입력하면 받아야한다. -> 변수선언: 위치(변수)
	void channelChange(int channel) {
		// this -> 자신의 객체를 의미한다. -> 생성해서 변수로 저장 -> 변수의 주소가 this
		// this <-> super 
		this.channel = channel; 
	}
	
	// object를 출력하고자 할때 자동적으로 호출 당해서 처리한 후 결과를 출력하게 해주는 메서드
	public String toString() {
		// getClass() -> 메서드 호출 : Object class에서 상속받았다.(내꺼다)
		// getName() -> package...className
		// getSimpleName() -> className : TV
		return getClass().getSimpleName() + "["+
		"color="+ color+","+"power="+power+","+"channel="+channel+"]";
	}
}// end of TV class