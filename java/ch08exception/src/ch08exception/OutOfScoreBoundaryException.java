package ch08exception;

// 예외 객체로 만들기 위해서 예외가 되어야 하는데 방법은 Exception을 상속 받으면 된다.
public class OutOfScoreBoundaryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 예외에서 사용한 기본 메시지 셋팅해서 사용
	public OutOfScoreBoundaryException() {
		// super는 부모 클래스이므로 Exception이 된다.
		super("점수는 0~100사이의 숫자를 입력하셔야 합니다. - 점수 범위 오류");
	}
	
	// 예외에서 사용할 메시지를 입력해서 사용
	public OutOfScoreBoundaryException(String msg) {
		super(msg);
	}

}
