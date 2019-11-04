package ch12annotation;

public class AnnotationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NewClass nc = new NewClass();
		nc.print();
	}

}

// @Deprecated은 예전에는 사용했으나 현재는 비효율적으로 생각이 되어
// 업버전 시킨 메서드를 사용하도록 한다.
// 지우면 멤버를 사용하고 있는 모든 프로그램이 동작을 하지 않게 된다.
class NewClass{
	@Deprecated
	int oldfield;
	
	@Deprecated
	public void print() {}
}