package ch06object;

public class TvTest {
	

	
	public static void main(String[] args) {
		 
		System.out.println("Main");
		//TV �ʿ��ϴ�. - ��ü�� �����ؼ� ����Ѵ�.
		// == �ν��Ͻ�ȭ ��Ų��. -> �ν��Ͻ��� �����. => �ڱ� �ڽ��� ��ü�� ���� �ּҸ� ������ ��
		TV tv = new TV();
		tv.color = "black";
		System.out.println(tv.color);
		
	}

}

class TV {
	// TV ������ �����ϴ� ���� - TV Ŭ������ ������(member ����)
	//- �޼��� �ȿ� ������ �ʴ�. ��������
	// new �� �� ������ �ǰ� ó���� ���� �̹� �����ϰ� �Ǿ��� �ִ�. �ʱ�ȭ�� �ݵ�� �Ǿ���Ѵ�.(�ڵ�)
	String color;  // �⺻������ null
	boolean power; // �����ִ��� �����ִ����� ���¸� �����ϴ� ���� // �⺻������ false
	int channel; // ���� ��û���� ä���� ������ �����ϴ� ���� // �⺻������ 0
	
	void print() {
		System.out.println(color);
		// �޼��� �ȿ� �ִ� ������ ����Ϸ��� �ݵ�� �ʱ�ȭ�� �������� ��������Ѵ�.
		String menu = null;
		System.out.println(menu);
	}
}