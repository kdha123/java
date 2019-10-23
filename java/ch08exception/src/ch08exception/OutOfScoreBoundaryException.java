package ch08exception;

// ���� ��ü�� ����� ���ؼ� ���ܰ� �Ǿ�� �ϴµ� ����� Exception�� ��� ������ �ȴ�.
public class OutOfScoreBoundaryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ���ܿ��� ����� �⺻ �޽��� �����ؼ� ���
	public OutOfScoreBoundaryException() {
		// super�� �θ� Ŭ�����̹Ƿ� Exception�� �ȴ�.
		super("������ 0~100������ ���ڸ� �Է��ϼž� �մϴ�. - ���� ���� ����");
	}
	
	// ���ܿ��� ����� �޽����� �Է��ؼ� ���
	public OutOfScoreBoundaryException(String msg) {
		super(msg);
	}

}
