package ch06object;

public class Person {
//  id번호, 이름, 생년월일, 성별, 연락처, 국적
	private String id, name, birth,gender,tel,nation;
	
	// 생성자 - 클래스 이름과 동일, return 타입이 없다.
	// 기본 생성자 - 생략 가능하다. 생략하고 생성자가 없으면 javac가 만들어준다.
//	public Person() {}
	
	// 데이터 받기 : getter - getId()
	// 데이터 넣기 : setter - setId(String id)
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
	// 위에 올려 넣기. Object.toSting()있고  Person.toString()
	// Person클래스가 Object(부모클래스)가 가지고 있는 모든 것을 상속 받으므로
	// toString()가 이미 존재하게 된다. 그러나 본인만의 처리를 할 수 있는 toString()를 
	// 선언할 수 있는데 toString()를 호출하면 본인만의 처리 메서드인 Person.toString()가
	// 호출당한다. 아래에 부모클래스가 가지고 있던 toString() 올리고 그 위에 새로 작성한 
	// toString()를 올려 놓은 형식이 되어서 위에 올려놓은 Person.toString()만 볼 수 밖에 없다.
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", tel=" + tel
				+ ", nation=" + nation + "]";
	}
}
