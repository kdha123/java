package ch06object;

public class PersosnTest {

	public static void main(String[] args) {
		
		System.out.println("PersonTest.main() start");
		
		// ����� ���� ó�� -> ���(Person)��ü�� �ʿ��ϴ�.
		// new Person() -> �⺻ ������ ȣ�� : �����ڰ� ������ javac�� �ڵ������� ������ش�.
		Person person = new Person();
		System.out.println(person);
		Person2 person2 = new Person2();
		System.out.println(person2);
		System.out.println("Person2 ���� -> person22 ��");
		
		// ����� ����� ���� �ݵ�� id, �̸�, ������ �ݵ�� �Է��ؾ��Ѵ�.
		Person2 person22 = new Person2("1002","test","Korea");
		System.out.println("Person2 ���� -> person22 ��");
		System.out.println(person22);
		
		// ��� ��ü�� ������ ����� ���
		// person22�� ����ó�� �����غ���.
		person22.setTel("010-2222-2222");
		// person22�� �̸��� ����ó ���
		System.out.println(person22.getName()+"���� ����ó��"+
		person22.getTel()+"�� ����Ǿ����ϴ�.");
		
		System.out.println("PersonTest.main() end");
		
	}

}
