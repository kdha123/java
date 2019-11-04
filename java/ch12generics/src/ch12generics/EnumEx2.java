package ch12enum;

// 방향 데이터 정의 - 4가지만 사용한다.
enum DirectionChar{
	// The constructor DirectionChar(int, String) is undefined
	// enum의 항목으로 되어있는 것을 생성을 하고 있는 것이다.
	EAST(1,">"), SOUTH(2, "V"), WEST(3,"<"), NORTH(4,"^");

	// 초기값을 셋팅(생성자, 초기화블록)할 수 있으나 처리문에 의해서 변경은 할 수 없다.
	private final int value;
	private final String symbol;
	
	// 위에 변수들이 private이므로 값을 가져갈 수가 없다. 가져갈 수 있도록 public getter작성
	public int getValue() {return value;}
	public String getSymbol() {return symbol;}

	//일반 생성자를 만들면 기본 생성자는 사라지게 된다.(자동으로 만들지 않는다.)
	private DirectionChar(int a, String symbol) {
		this.value = a;
		this.symbol = symbol;
	}

	//출력할 때 자동으로 객체를 문자열로 만들어 주는 메서드
	public String toString() {
		return "" + value+":"+symbol;
	}

}

public class EnumEx2 {
	
	public static void main(String[] args) {

		DirectionChar d1 = DirectionChar.EAST;
		System.out.println(d1);
		System.out.println(d1.toString());
		//d1이 Direction 타입이기때문에  toString으로 바꾼후 비교해봐야한다.
		if(d1.toString().equals("EAST"))
			System.out.println("같다.");
//		d1 = "Test";
		System.out.println("d1.name() : "+ d1.name());
		System.out.println("ordinal : "+ d1.ordinal());
		System.out.println(DirectionChar.valueOf("EAST"));
		// enum 데이터의 문자열을 알고 있을 때 처리하기
		String dstr = "WEST";
		d1 = DirectionChar.valueOf(dstr);
		System.out.println(d1);
		DirectionChar[] arrDir = DirectionChar.values();
		for(DirectionChar d : arrDir)
			System.out.println(d);
		// symbol 출력
		System.out.println(d1.getSymbol());
		System.out.println(d1.getValue());
		
	}

}
