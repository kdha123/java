package ch07object2.dto2;

public class SelfNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("SelfNew.main() : static");
		SelfNew selfNew = new SelfNew();
		selfNew.print();
	}

	public void print() {
		System.out.println("SelfNew.println() : non-static");
	}
}
