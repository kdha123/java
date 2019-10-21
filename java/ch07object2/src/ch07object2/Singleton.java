package ch07object2;

public class Singleton {

	// ���α׷� �߿��� Ŭ�����̸��� �߰��� �Ǹ� �ڵ����� �ö󰡹Ƿ� ������ �ؼ� �ʱ�ȭ���Ѽ� �־�д�.
	// �׷��� �������� ����� �� ����.
	private static Singleton singleton = new Singleton();
	
	// �ܺο��� ������ �ȵǴ� �����ڸ� �������. -> ���� Ŭ���������� ������ �� �ִ�.
	private Singleton() {
		// TODO Auto-generated constructor stub
		
	}
	// �ܺο����� ������ �� ������ �������� ����� �� �ֵ��� public getInstance()�޼��带 �����.
	// new�� �� �����Ƿ� static���� �����Ѵ�. Singleton.getInstance();
	public static Singleton getInstance() {
		return singleton;
	}
	// �����Ϸ��� �޼����
	public void print() {
		System.out.println("Singleton.print()");
	}
}
