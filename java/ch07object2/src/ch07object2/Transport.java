package ch07object2;

// �߻� �޼��带 ������ �ִ� Ŭ����-> �߻�Ŭ������� �Ѵ�. -> ���������� ������ �ȵ�.
// ������ �� �� ������ �߻�޼��带 �ذ��ؾ��Ѵ�.
public abstract class Transport {
	
	public String name = "�赿��";
	
	// �Ϲݸ޼��� ��������
	public int pay() {return 100;}
	
	// �̵��ϴ� ���� �޼��� -> ������ Ÿ���� ������ �ȵƴ�.
	public abstract void move();//{}����. ���� ����. -> �߻�޼���
}
