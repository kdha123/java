// Ŭ������ ��ġ ������ �ִ� ���� Ȯ���ؼ� �ۼ�
package ch03operator;

// Ŭ���� ���� - ���ϸ��� Ȯ���ؼ� �ۼ�
public class OperatorEx1SingleOp{
	// �ڵ������� �ν��ؼ� �����̵Ǵ� �޼��� main() �ۼ�
	public static void main(String[] args) {
		// i ���� ���� �Ŀ� �ʱⰪ ����
		int i = 5;
		System.out.println("i = " + i);
		// i ������ 1���� ��Ű��.
		i = i + 1; // 6
		System.out.println("i = " + i);
		i += 1; // 7
		System.out.println("i = " + i);
		++i; // ++i : �� ���� �� ó�� , 8
             // �ܵ����� �������� ����Ҷ��� �� ������ �� ������ ����� ����.		
		System.out.println("i = " + i);
		i++; // i++ : �� ó�� �� ����, 9
		System.out.println("i = " + i); 
		System.out.println("i = " + ++i +"// i = "+ ++i);// 10 11
		System.out.println("i = " + i++ +"// i = "+ i++);// 11 12
		System.out.println("i = " + i); // 13
		// 1���� - ��� ���� ó��
		i++; //14
		// ���
		System.out.println("i = " + i);
		// ���� 2���� �� �ٷ� ���� �� �ִ�.
		System.out.println("i = " + ++i); //15
		
		//��� - �����ϱ� ���� ���
		System.out.println("i = " + i); //15
		// 1���� - ��� �Ŀ� ó��
		i++; //16
		// ���
		// ���� 2���� �� �ٷ� ���� �� �ִ�.
		System.out.println("i = " + i++);//16
	}
}