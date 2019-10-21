package ch07object2;

public class BoardDAOTest {

	static BoardDAO boardDAO = null; //null.list() ����Ϸ��� ������ �ݵ�� �ؾ��Ѵ�.
	static String dbms = "oracle";
	public static void main(String[] args) {
		
		dbms = args[0];
		if(dbms == null);
		else if(dbms.equals("oracle"))
			boardDAO = new OracleBoardDAO();
		else if(dbms.equals("mysql"))
			boardDAO = new MySQLBoardDAO();
		
		// ����Ʈ ó��
		boardDAO.list();
	}
}
