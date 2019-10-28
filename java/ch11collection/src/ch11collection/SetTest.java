/*
 * 컬렉션 - 여러 개의 데이터를 담는 객체
 * List - 데이터의 나열 : 중복을 허용
 * Set - 데이터의 묶음 : 중복을 허용하지 않는다.
 */
package ch11collection;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<String>();
		set.add("김동현");
		set.add("아이린");
		set.add("김동현");
		set.add("슬기");
		System.out.println(set); // 중복을 허용하지않는다.
		System.out.println(set.size());
		// 데이터 순서대로 출력해본다.
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext())
			System.out.println(iter.next());
		
		// 로또 프로그램 작성 - 랜덤숫자를 발생시킨다. -> 1~45 : 6개의 숫자 (중복이 되면 안된다.)
		Set<Integer> lotto = new HashSet<Integer>();
		while(true) {
			int num = (int) ((Math.random()*44)+1);
			lotto.add(num);
			if(lotto.size()==6) {
				System.out.println(lotto);
			break;
		}

			
	}

}
}
