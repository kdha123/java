package ch07object2.dto2;

import ch07object2.dto.Data;

public class DataImpl extends Data{

	// ��ӹ��� ������ �� ������. -> ���� ��Ű�������� private�� ����
	
	public void print() {
		System.out.println(pubInt);
		System.out.println(proInt); // �ٸ� ��Ű�������� ����ؼ� ����� �� �ִ�. new�ȵ�
//		System.out.println(defInt); // �ٸ� ��Ű���� ��� ���, new �Ѵ� �Ұ���
//		System.out.println(priInt); // private���� ������ ���� ������� �ʴ´�.
	}
}
