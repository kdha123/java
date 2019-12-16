package boardmysql;
import java.sql.*;//Connection, Statement, ResultSet, PreparedStatement
import java.util.*;

import javax.sql.*;//DateSource
import javax.naming.*;//lookup


//DAO: DBó���ϴ� ����Ͻ� ����
public class BoardDAO {
	//���� ����
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "";
	
	//�̱��� ��ü ������ ���̴�. �޸� ���� ȿ��
	private static BoardDAO dao = new BoardDAO();
	
	//����Ʈ ������ private�� ������ ������ �ܺο��� ��ü���� ���ϰ� �Ϸ���!
	private BoardDAO(){};
	
	//jsp���� dao��ü�� ����� �޼���
	public static BoardDAO getDAO(){
		return dao;
	}
	
	//Ŀ�ؼ� ���, �޼���
	private Connection getCon() throws Exception{
		Context ct = new InitialContext();
		DataSource ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}//getCon() end
	
	//----------------
	// ����, ��� ����
	//----------------
	
	public void insertArticle(BoardDTO dto) throws Exception{
		int num = dto.getNum();// 0�̸� ����, 0�� �ƴϸ� ���
		int ref = dto.getRef();// ����̸� ���� �Ѿ�´�.
		int re_step = dto.getRe_step();// ����̸� ���� �Ѿ�´�.
		int re_level = dto.getRe_level();//����̸� ���� �Ѿ�´�.
		
		int number = 0;// �� �׷� ó���ϱ� ���� ����
		
		try{
			con = getCon();// Ŀ�ؼ� ���
			//DB�� �׷��Լ� : count, max, min, avg
			
			// �ִ� �۹�ȣ ���
			pstmt = con.prepareStatement(" select max(num) from board ");
			rs = pstmt.executeQuery();
			if(rs.next()){// ���� �����ϸ�
				number = rs.getInt(num)+1;
			}else{
				number = 1; //ó�����̸� ref=number
			}// if else end
			
		}catch(Exception ex1){
			System.out.println("insertArticle() ���� : "+ex1);
		}finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex3) {}
		}//finally
	}//insertArticle() end
}//class end
