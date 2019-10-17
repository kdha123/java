package ch06object;

public class Person {
//  id��ȣ, �̸�, �������, ����, ����ó, ����
	private String id, name, birth,gender,tel,nation;
	
	// ������ - Ŭ���� �̸��� ����, return Ÿ���� ����.
	// �⺻ ������ - ���� �����ϴ�. �����ϰ� �����ڰ� ������ javac�� ������ش�.
//	public Person() {}
	
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
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", tel=" + tel
				+ ", nation=" + nation + "]";
	}
}
