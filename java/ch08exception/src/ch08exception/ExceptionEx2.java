package ch08exception;

public class ExceptionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 100 / ��������(0~9)
		int number = 100;
		int result = 0;
		
		for(int i = 0; i < 10;i++) {
			// 100 / 0~9�� �������ڷ� ������. -> �������ڰ� 0�̸� ���ܰ� �߻�
			try {
				result = number /(int)(Math.random() * 10);
				System.out.println(result);
				// try ���� ó�������� ���ܰ� �߻��̵Ǹ� �׿� �ش�Ǵ� ���� ��ü�� �����ؼ� catch
				// �Ķ���Ϳ� �����ؼ� �ִ´�.
				} catch (ArithmeticException e) {
					// ����ڸ� ���� �޼��� ó��
					System.out.println("������ ������� (0���� ����)-out���");
					System.out.println(e.getMessage());
					// �����ڸ� ���� �޼��� ó��
					System.err.println("������ ������� (0���� ����)-err���");
					e.printStackTrace();
				}finally {
					System.out.println("finally - �ݵ�� �����̵ȴ�.");
				}
		}
	}

}
