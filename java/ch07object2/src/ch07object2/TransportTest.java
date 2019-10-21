package ch07object2;

public class TransportTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 부산까지 이동
		move(new Bus());
		move(new Airport());
	}
	public static void move(Transport transport) {
		transport.move();
	}

}
