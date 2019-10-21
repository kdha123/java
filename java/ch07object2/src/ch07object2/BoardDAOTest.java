package ch07object2;

public class BoardDAOTest {

	static BoardDAO boardDAO = null; //null.list() 사용하려면 생성을 반드시 해야한다.
	static String dbms = "oracle";
	public static void main(String[] args) {
		
		dbms = args[0];
		if(dbms == null);
		else if(dbms.equals("oracle"))
			boardDAO = new OracleBoardDAO();
		else if(dbms.equals("mysql"))
			boardDAO = new MySQLBoardDAO();
		
		// 리스트 처리
		boardDAO.list();
	}
}
