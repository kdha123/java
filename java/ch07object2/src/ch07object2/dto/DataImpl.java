package ch07object2.dto;

public class DataImpl extends Data{

	// ��ӹ��� ������ �� ������. -> ���� ��Ű�������� private�� ����
	
	public void print() {
		System.out.println(pubInt);
		System.out.println(proInt);
		System.out.println(defInt);
//		System.out.println(priInt); // private���� ������ ���� ������� �ʴ´�.
	}
}
