package main;

public interface Service {

	// final 변수, 추상 메서드
	// 호출할 때에 0개 이상의 데이터를 전달할 수 있다.
	// 결과를 한개 리턴해야만 한다. -> 리턴할 것이 없으면 return null;
	public Object service(Object ... objs);
	
}
