package ch06object;

public class TvTest {
	

	
public static void main(String[] args) {
		 
	System.out.println("Main");
	//TV �ʿ��ϴ�. - ��ü�� �����ؼ� ����Ѵ�.
	// == �ν��Ͻ�ȭ ��Ų��. -> �ν��Ͻ��� �����. => �ڱ� �ڽ��� ��ü�� ���� �ּҸ� ������ ��
	TV tv1 = new TV();
	TV tv2 = new TV();
	System.out.println(tv1.toString() + "/"+tv2);
	tv1.color = "black";
	System.out.println(tv1.color);
		
	// tv1 ��ü�� ����� ����غ���.
	// ���� ����
	tv1.powerOnOff();
	System.out.println(tv1);
	
	//ä�� �ø���
	tv1.channelUp();
	System.out.println(tv1);
	
	//ä�γ�����
	tv1.channelDown();
	System.out.println(tv1);
	
	//ä�κ���
	tv1.channelChange(11);
	System.out.println(tv1);
	
	
	// ��� Ŭ������ �⺻������ Object�� ��ӹ޴´�.
	// Object(�θ�Ŭ����) - TV(�ڽ�Ŭ����:Object�� ������ �ִ� ���� ��� �޴´�.)
	// �߿� : ���谡 �����. -> ĳ����(����ȯ)�� �����ϴ�.
	// TV - Object�� ����µ��� ������ ����.
	// Object -> TV�� ĳ������ ���� ������ �ִ�. ObjectŸ�Կ� TV��ü�� �����س��� ��츸 ����
	Object obj = new TV(); // �� -> ū : �ڵ� ĳ����
	System.out.println(obj.toString());
	((TV)obj).channelUp();
	System.out.println(obj);
	
	// Object �ȿ� ���� ���� String -> Object[String]
	obj = new String("test");
//	((TV)obj).channelUp(); // TV�� String�� ���� ĳ������ �� ���� ������ ���� 
	System.out.println(obj);
	
	
	} // end of main()

}// end of TvTest class

// Ŭ���� ����
class TV {
	// TV ������ �����ϴ� ���� - TV Ŭ������ ������(member ����)
	//- �޼��� �ȿ� ������ �ʴ�. ��������
	// new �� �� ������ �ǰ� ó���� ���� �̹� �����ϰ� �Ǿ��� �ִ�. �ʱ�ȭ�� �ݵ�� �Ǿ���Ѵ�.(�ڵ�)
	String color;  // �⺻������ null
	boolean power; // �����ִ��� �����ִ����� ���¸� �����ϴ� ���� // �⺻������ false
	int channel; // ���� ��û���� ä���� ������ �����ϴ� ���� // �⺻������ 0
	
	// ������ - ������ �� ȣ���ؼ� ����ϴ� Ư���� �޼��� , javac�� �����ڰ� ������ �ڵ������� �����.
	public TV() {} 
	
	
	void print() {
		System.out.println(color);
		// �޼��� �ȿ� �ִ� ������ ����Ϸ��� �ݵ�� �ʱ�ȭ�� �������� ��������Ѵ�.
		String menu = null;
		System.out.println(menu);
	} // end of print()
	
	// �����ѱ� ���� : true -> false, false -> true(not : !)
	void powerOnOff() {	power = !power;}// ! : not	
	// ä�� �ø���
	void channelUp() { channel++;}
	// ä�� ������
	void channelDown() { channel--;}
	// ä�� ����-> ��ȣ�� �Է��ϸ� �޾ƾ��Ѵ�. -> ��������: ��ġ(����)
	void channelChange(int channel) {
		// this -> �ڽ��� ��ü�� �ǹ��Ѵ�. -> �����ؼ� ������ ���� -> ������ �ּҰ� this
		// this <-> super 
		this.channel = channel; 
	}
	
	// object�� ����ϰ��� �Ҷ� �ڵ������� ȣ�� ���ؼ� ó���� �� ����� ����ϰ� ���ִ� �޼���
	public String toString() {
		// getClass() -> �޼��� ȣ�� : Object class���� ��ӹ޾Ҵ�.(������)
		// getName() -> package...className
		// getSimpleName() -> className : TV
		return getClass().getSimpleName() + "["+
		"color="+ color+","+"power="+power+","+"channel="+channel+"]";
	}
}// end of TV class