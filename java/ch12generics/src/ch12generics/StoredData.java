package ch12generics;

import java.util.ArrayList;

public class StoredData {

	private ArrayList<Object> dataList = new ArrayList<Object>();
	
	// 데이터를 저장하는 메서드 
	public void add(Object obj) {
		dataList.add(obj);
	}
	
	// 데이터를 받나내느 메서드
	public Object get(int index) {
		return dataList.get(index);
	}
	
	// 리스트를 받아내는 메서드
	public ArrayList<Object> getList() {
		return dataList;
	}
	
	// 데이터의 개수를 알아내는 메서드
	public int size() {
		return dataList.size();
	}
}
