package ch07object2;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		excute(new InterfaceImplFacFor());
		excute(new InterfaceImplFacRecall());
		excute(new InterfaceExcute() {
			// �͸�Ŭ���� �ۼ� -> �ѹ��� ó���ϰ� ������. : AWT - �ڹ� â ��ü-> ��ưó��
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("a�� ����");
			}
		});
		excute(new InterfaceExcute() {
			// �͸�Ŭ���� �ۼ� -> �ѹ��� ó���ϰ� ������. : AWT - �ڹ� â ��ü-> ��ưó��
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("b�� ����");
			}
		});
	}

	// �������̽��� �޾Ƽ� �����ϴ� �޼���
	// �����ϴ� �ð��� üũ�ϴ� ���α׷�
	// proxy program -> �ٷ� ������ �ȵǰ� �� �ڷ� ������ ó���� �ǰ��� �߰��� ó���ǵ��� ���� ���α׷�
	public static void excute(InterfaceExcute ie) {
		// �ð��� ������
		long startTime = System.nanoTime();
		ie.excute();
		long endTime = System.nanoTime();
		System.out.println("�ҿ�ð� : "+ (endTime - startTime));
	}
}
