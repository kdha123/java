package ch04condition;

public class FlowEx33LabelBreak {

	public static void main(String[] args) {
//		Loop1 : //��(:)�� �ٿ��� �̵��� �� ����Ѵ�. -> switch(case �� : ~~)
		//break : switch, for, while - ���� ������ ���ΰ� �ִ� �Ѱ�
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j<=9; j++) {
				// �������� ���� ���� ����
//				if(j==5) break Loop1;
				if(j==5) continue; // j�� 5�̸� �Ʒ� ����� �����ʰ� �ݺ����� ó������ ����.
				System.out.println(i +" * "+ j + " = " +(i * j));
			} // end of for j
			System.out.println();
		}   // end of for i 
		System.out.println("������ ó�� ��~~~~");
		}

}
