package ch06object;
/*
 * Person 클래스를 수정했다.
 * 생성을 하면 모든 String 변수들의 값이 null이므로 기본 값을 가지도록 처리
 */
public class Person2 {
//  id번호, 이름, 생년월일, 성별, 연락처, 국적
	private String id, name, birth,gender,tel,nation;
	
	// 초기화 블록은 (매개변수) 없다. 값은 전달 못함. --> 값 변경이 안되고 초기화 블록안에 있는 값만 사용.
	// static 초기화블록(static{})- 호출하지 않아도 자동적으로 실행되므로 이름이 필요하지 않다.
	// 고정 초기화 블록 - 클래스가 맨처음 찾게 되면 실행이된다. -> 맨처음 new는 실행, 다음부터 실행안됨
	static{
		System.out.println("static 초기화 블록 실행");
	}
	
	
	// 초기화 블록({}) - 호출하지 않아도 자동적으로 실행이되므로 이름이 필요하지 않다.
	// non static : new와 관련이 있다. 인스턴스 초기화 블록
	{
		System.out.println("초기화블록실행");
	}
	
	
	// 생성자 - 클래스 이름과 동일, return 타입이 없다.
	// 기본 생성자 - 생략 가능하다. 생략하고 생성자가 없으면 javac가 만들어준다.
	public Person2() {
		// 부모 클래스를 먼저 생성하고 자신을 생성하게 된다. 
		// 생성이 되어 있어야 내것으로 가져올 수 있다.
		// 기본이므로 생략 가능하다 .(부모 클래스의 기본 생성자 호출)
		super();  
		System.out.println("Peson2()의 기본생성자 실행");
		id = "1001";
		name = "홍길동";
		birth = "2000-01-01";
		gender = "남자";
		tel = "010-1111-1111";
		nation = "Korea";
	}
	
	// 생성자  - id, 이름,국적
	public Person2(String id,String name, String nation){
		this(); // 나머지를 기본값으로 넣기 : 생성자에서 생성자를 호출
		System.out.println("Peson2(id...) 생성자 실행");
		this.id = id;
		this.name = name;
		this.nation = nation;
	}
	
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
		System.out.println("Person2.toString() 실행 - 데이터확인");
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", tel=" + tel
				+ ", nation=" + nation + "]";
	}
}
