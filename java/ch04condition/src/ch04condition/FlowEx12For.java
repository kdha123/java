package ch04condition;

public class FlowEx12For {

	public static void main(String[] args) {
		
		// 1~5���� ����ϴ� ���α׷� �ۼ� -> �����Ͱ� 1���� 5���� ���Ѵ�. : ������ �ʿ��ϴ�.
		
		//�ϵ��ڵ��� ������ ����
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
	    
		// �ݺ��� : �����ϴ� ���� ������ ���� ������ �ְ� �����Ǵ� ���� �����ϴ�. -> for�� ���
		// for(�ʱⰪ; �ݺ� ����; ������){ �ݺ�ó�� }
		for(int i = 1; i <= 5; i++)
			System.out.println(i);

//		System.out.println(i); -- for�ȿ��� ����� ������ �ۿ��� ����� �� ����.
		int i = 1;
		for(;i<=5;i++)System.out.println(i);
		System.out.println("for �� �ۿ��� ��µ� i : "+ i);
		
		i = 1;
		for(; i<=5;) {
			System.out.println(i++);	
		}
		
		i=1;
		for(;;) { //���� �ݺ� : while(true)�� ����
			if(!(i<=5)) break; // �ݺ�ó�� ���� ����
			System.out.println(i); //�������� ó����
			i++; // ������
		}
	}

}
