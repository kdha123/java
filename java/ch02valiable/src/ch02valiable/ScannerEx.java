package ch02valiable;

// �ٸ� ��Ű���� ��ġ�� �ִ� Ŭ������ import(���Խ�Ų��.)
// ��û ���� ����ϴ� ��Ű���� ������� import�� ������� �ʴ��� �ڵ� import�Ѵ�.
// --> java.lang ��Ű���� �ڵ� import �Ѵ�.
// import java.util.*; --> java.util.��� ���� �� import�ϰڴ�.
import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		// �����͸� �Է��� �� ����ϴ� Ŭ���� - ǥ���Է��� ���ؼ� System.in�� �������ش�.
		// new : ���� �����. ���� �޸𸮿� ���� ���� HDD���� �ø���.
		// new �� ũ�Ⱑ ������ ���� �ʴ� ������ �޸𸮿� �ø��� �ٽ� ����ϱ� ���ؼ� ������ �ø� ��ġ(�ּ�)�� �����Ѵ�.
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڸ� ������ �ϳ� �Է��� �ּ���: -->");
		String input = scanner.nextLine();
		System.out.println(input);
		System.out.println(input+10);
		// Integer Ŭ���� : int �����͸� ������ �ִ� ������ �ִ�. 
		// �� �� int ó���� �� �� �ִ� �޼ҵ� �� ������ �ִ�. wrapper Ŭ���� - �⺻�� �����͸� ���ΰ� �ִ� Ŭ���� - ó���� �ʿ��� �޼ҵ���� ������ �ִ�.
		int num = Integer.parseInt(input);
		System.out.println(num+10);
		System.out.println("int�� �ְ� ū ����:"+ Integer.MAX_VALUE);
		
		scanner.close();
	}
}
