package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDAOList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// DB 필요한 접속 정보
		String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
		String id = "c##java04";
		String pw = "java04";
		// 어떤 드라이버(DB 실행시키는 프로그램)인지 쓸 수 있도록 처리해야한다.
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 오라클 연결
		try {
		// 정상처리
			System.out.println("정상처리 시작");
			System.out.println("드라이버 확인");
		// 1. 드라이버 확인
			Class.forName(driver);
		// 2. DB와 연결
			System.out.println("오라클 연결 시도");
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("연결결과 : "+ con);
		// 3. 실행할 쿼리문 작성
			String sql = " select no, title, content, startDate, endDate, writeDate, updateDate from notice  ";
		// 4. 연결 객체에서 실행객체를 꺼내서 실행한다.
			PreparedStatement pstmt = con.prepareStatement(sql);
		// 5. select -> 데이터 꺼내오기 - ResultSet(DB table 구조
			ResultSet rs = pstmt.executeQuery();
		// 6. 가져온 데이터 표시 / 저장(DTO->List)
			if(rs!=null)
				while(rs.next())
				{
					System.out.println(rs.getInt("no"));
					System.out.println(rs.getString("title"));
					System.out.println(rs.getString("content"));
					System.out.println(rs.getString("startDate"));
					System.out.println(rs.getString("endDate"));
					System.out.println(rs.getString("writeDate"));
					System.out.println(rs.getString("updateDate"));
				}		
			// 7. 사용한 객체 닫기- con, pstmt, rs
			con.close();
			pstmt.close();
			rs.close();
			System.out.println("정상처리의 끝");
			// 예외처리
	} catch ( ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	}

}
