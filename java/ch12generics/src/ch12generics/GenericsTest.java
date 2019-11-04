package ch12generics;

import java.util.ArrayList;

public class GenericsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StoredData list = new StoredData();
		list.add("김동현");
		list.add(1234);
		System.out.println(list.get(1));
		for(Object obj : list.getList())
			System.out.println(obj);
//		System.out.println(list.getList().size());
		System.out.println(list.size());
			
		// 입력 데이터의 타입을 한정해서 사용해보자.-> 객체 안에서 선언하지 않고 밖에서 사용할 때 선언
		ArrayList<String> al = null;
		GenericsData<String> list2 = new GenericsData<String>();
		list2.add("김동현");
//		list2.add(1234); //생성할 당시에 제네릭스 타입을 지정해서 사용하고있다. 문자열로
		System.out.println(list2.get(0));
		for(String str : list2.getList())
			System.out.println(str);
//		System.out.println(list.getList().size());
		System.out.println(list2.size());
		
		
	}

}
