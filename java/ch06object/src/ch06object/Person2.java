package ch06object;
/*
 * Person Ŭ������ �����ߴ�.
 * ������ �ϸ� ��� String �������� ���� null�̹Ƿ� �⺻ ���� �������� ó��
 */
public class Person2 {
//  id��ȣ, �̸�, �������, ����, ����ó, ����
	private String id, name, birth,gender,tel,nation;
	
	// �ʱ�ȭ ����� (�Ű�����) ����. ���� ���� ����. --> �� ������ �ȵǰ� �ʱ�ȭ ��Ͼȿ� �ִ� ���� ���.
	// static �ʱ�ȭ���(static{})- ȣ������ �ʾƵ� �ڵ������� ����ǹǷ� �̸��� �ʿ����� �ʴ�.
	// ���� �ʱ�ȭ ��� - Ŭ������ ��ó�� ã�� �Ǹ� �����̵ȴ�. -> ��ó�� new�� ����, �������� ����ȵ�
	static{
		System.out.println("static �ʱ�ȭ ��� ����");
	}
	
	
	// �ʱ�ȭ ���({}) - ȣ������ �ʾƵ� �ڵ������� �����̵ǹǷ� �̸��� �ʿ����� �ʴ�.
	// non static : new�� ������ �ִ�. �ν��Ͻ� �ʱ�ȭ ���
	{
		System.out.println("�ʱ�ȭ��Ͻ���");
	}
	
	
	// ������ - Ŭ���� �̸��� ����, return Ÿ���� ����.
	// �⺻ ������ - ���� �����ϴ�. �����ϰ� �����ڰ� ������ javac�� ������ش�.
	public Person2() {
		// �θ� Ŭ������ ���� �����ϰ� �ڽ��� �����ϰ� �ȴ�. 
		// ������ �Ǿ� �־�� �������� ������ �� �ִ�.
		// �⺻�̹Ƿ� ���� �����ϴ� .(�θ� Ŭ������ �⺻ ������ ȣ��)
		super();  
		System.out.println("Peson2()�� �⺻������ ����");
		id = "1001";
		name = "ȫ�浿";
		birth = "2000-01-01";
		gender = "����";
		tel = "010-1111-1111";
		nation = "Korea";
	}
	
	// ������  - id, �̸�,����
	public Person2(String id,String name, String nation){
		this(); // �������� �⺻������ �ֱ� : �����ڿ��� �����ڸ� ȣ��
		System.out.println("Peson2(id...) ������ ����");
		this.id = id;
		this.name = name;
		this.nation = nation;
	}
	
	// ������ �ޱ� : getter - getId()
	// ������ �ֱ� : setter - setId(String id)
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	// ���� �÷� �ֱ�. Object.toSting()�ְ�  Person.toString()
	// PersonŬ������ Object(�θ�Ŭ����)�� ������ �ִ� ��� ���� ��� �����Ƿ�
	// toString()�� �̹� �����ϰ� �ȴ�. �׷��� ���θ��� ó���� �� �� �ִ� toString()�� 
	// ������ �� �ִµ� toString()�� ȣ���ϸ� ���θ��� ó�� �޼����� Person.toString()��
	// ȣ����Ѵ�. �Ʒ��� �θ�Ŭ������ ������ �ִ� toString() �ø��� �� ���� ���� �ۼ��� 
	// toString()�� �÷� ���� ������ �Ǿ ���� �÷����� Person.toString()�� �� �� �ۿ� ����.
	@Override
	public String toString() {
		System.out.println("Person2.toString() ���� - ������Ȯ��");
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", tel=" + tel
				+ ", nation=" + nation + "]";
	}
}
