package ch04condition;

public class FlowEx23While {

	public static void main(String[] args) {
		int i = 1;
		
		i = 1;
		for(; i<=5;) {
			System.out.println(i++);	
		}
		
		
		// ���ǿ� ���� �ݺ�ó��
		i = 1;
		System.out.println("while���� �̿��� ��� =======");
		while(i<=5)
			System.out.println(i++);
		
		
		
		i = 1;
		for(;;) { //���� �ݺ� : while(true)�� ����
			if(!(i<=5)) break; // �ݺ�ó�� ���� ���� -> �ݺ����� ���������� ����
			System.out.println(i); //�������� ó����
			i++; // ������
			
		}
		
		i = 1;
		while(true) { 
			if(!(i<=5)) // �ݺ�ó�� ���� ���� -> �ݺ����� ���������� ����
				break; 
			System.out.println(i); //�������� ó����
			i++; // ������
		
			
		}
	}

}
