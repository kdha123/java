// Ŭ������ ��ġ�� ���ľ� �Ѵ�.
package ch02valiable;

// ���� �̸��� ���� Ŭ������ �ۼ��Ѵ�. public
public class PrintfEx1{
	// Ŭ������ ������ �ִ� ������ �ۼ�
	
	// �ڹٰ� �ڵ����� ������ �޼���(main()) �ۼ�
	// public ������: �ٸ� ����� ��ü���� ��밡���ϴ�.
	// static ���� : ���� �޸𸮿� �ö󰡼� �ڹٰ� ����� ������ �޸��� �ּҸ� �״�� ������ �ִ�.
	// void ����. : main() ó���� �� ������ �����޴� ���� ����. ���� Ÿ�� - �޼��� �տ��� �ִ� Ÿ��
	// String : ���ڿ� - ������ ���� 
	// [] �迭 : ������
	// args ���� �̸� : �ּҰ� ��� �ִ� ���� - ������ ����
	public static void main(String[] args) {
		// Ÿ�� ������ --> ���� ����
		// ������ = �� ó���� ������ �ʱⰪ ����
		int finger = 10;
		System.out.println(finger);
		// ������ �̾� ���̱⸦ ����ؼ� ���ڿ��� ����� ���
		System.out.println("finger = "+finger);
		// ���� ���ڿ��� ����� ��ü����(%���Ĺ���)�� �����͸� ����ϰ� ����� �����͸� ","�� �̿��ؼ�
		// �������ش�. �̶� ��ü���ڿ� ����� �������� ������ ���ƾ��Ѵ�.
		// %n : �ٹٲ� ��ü����
		System.out.printf("finger = %d%n", finger);
		// %������ڸ���d
		System.out.printf("finger = [%5d]%n", finger);
		// %-�ڸ���d : ���� ������ �������ε� "-" �ٿ��� ���� ����
		System.out.printf("finger = [%-5d]%n", finger);
		// �ڸ����� ũ�� ���鹮�ڰ� �⺻�ε� 0���� ä����� %0�ڸ���d �� ����Ѵ�.
		System.out.printf("finger = [%05d]%n", finger);
		// ���� ���
		System.out.printf("finger(hex) = [%x]%n", finger);
		System.out.printf("finger(oct) = [%o]%n", finger);
		System.out.printf("finger(bin) = [%s]%n", Integer.toBinaryString(finger));
		System.out.printf("finger(hex) = [%x] / finger(oct) = [%o]%n", finger,finger);		
	}
}