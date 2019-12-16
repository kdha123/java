package boardmysql;
import java.sql.*;//Connection, Statement, ResultSet, PreparedStatement
import java.util.*;

import javax.sql.*;//DateSource
import javax.naming.*;//lookup


//DAO: DB처리하는 비즈니스 로직
public class BoardDAO {
	//변수 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "";
	
	//싱글톤 객체 생성할 것이다. 메모리 절약 효과
	private static BoardDAO dao = new BoardDAO();
	
	//디폴트 생성자 private로 선언한 이유는 외부에서 객체생성 못하게 하려고!
	private BoardDAO(){};
	
	//jsp에서 dao객체를 사용할 메서드
	public static BoardDAO getDAO(){
		return dao;
	}
	
	//커넥션 얻기, 메서드
	private Connection getCon() throws Exception{
		Context ct = new InitialContext();
		DataSource ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}//getCon() end
	
	//----------------
	// 원글, 답글 쓰기
	//----------------
	
	public void insertArticle(BoardDTO dto) throws Exception{
		int num = dto.getNum();// 0이면 원글, 0이 아니면 답글
		int ref = dto.getRef();// 답글이면 값이 넘어온다.
		int re_step = dto.getRe_step();// 답글이면 값이 넘어온다.
		int re_level = dto.getRe_level();//답글이면 값이 넘어온다.
		
		int number = 0;// 글 그룹 처리하기 위한 변수
		
		try{
			con = getCon();// 커넥션 얻기
			//DB의 그룹함수 : count, max, min, avg
			
			// 최대 글번호 얻기
			pstmt = con.prepareStatement(" select max(num) from board ");
			rs = pstmt.executeQuery();
			if(rs.next()){// 글이 존재하면
				number = rs.getInt(num)+1;
			}else{
				number = 1; //처음글이면 ref=number
			}// if else end
			
		}catch(Exception ex1){
			System.out.println("insertArticle() 예외 : "+ex1);
		}finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex3) {}
		}//finally
	}//insertArticle() end
}//class end
