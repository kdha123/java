package ch12generics;

import java.util.ArrayList;

// GenericsData를 생성할 때 <T> 대신에 타입을 지정하면 지정된 타입으로 바꿔치기를 해준다.
// 그리고 컴파일한다.
public class GenericsData<E>{

	// 저장 변수
	private ArrayList<E> dataList = new ArrayList<E>();
	
	// 데이터를 저장하는 메서드 
		public void add(E obj) {
			dataList.add(obj);
		}
		
		// 데이터를 받나내느 메서드
		public E get(int index) {
			return dataList.get(index);
		}
		
		// 리스트를 받아내는 메서드
		public ArrayList<E> getList() {
			return dataList;
		}
		
		// 데이터의 개수를 알아내는 메서드
		public int size() {
			return dataList.size();
		}
}
