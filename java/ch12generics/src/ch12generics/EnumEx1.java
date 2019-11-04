package ch12enum;

// 방향 데이터 정의 - 4가지만 사용한다.
enum Direction { EAST, SOUTH, WEST, NORTH}

public class EnumEx1 {
	
	public static void main(String[] args) {

		Direction d1 = Direction.EAST;
		System.out.println(d1);
		//d1이 Direction 타입이기때문에  toString으로 바꾼후 비교해봐야한다.
		if(d1.toString().equals("EAST"))
			System.out.println("같다.");
//		d1 = "Test";
		System.out.println("d1.name() : "+ d1.name());
		System.out.println("ordinal : "+ d1.ordinal());
		System.out.println(Direction.valueOf("EAST"));
		// enum 데이터의 문자열을 알고 있을 때 처리하기
		String dstr = "WEST";
		d1 = Direction.valueOf(dstr);
		System.out.println(d1);
		Direction[] arrDir = Direction.values();
		for(Direction d : arrDir)
			System.out.println(d);
		
	}

}
