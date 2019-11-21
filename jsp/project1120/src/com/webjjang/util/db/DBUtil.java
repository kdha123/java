package com.webjjang.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	// 오라클 드라이버
	private static final String driver
	= "oracle.jdbc.driver.OracleDriver";
	
	// 접속 정보
	// 객체에서 사용할 DB 정보 -> list(), view().. 다른 메서드에서 다 필요로 하기 때문에
	// 전역변수로 선언한다.
	private static final String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
	private static final String id = "c##java04";
	private static final String pw = "java04";
	
	// 드라이버 확인 변수
	// true -> 드라이버가 있음, false - 드라이버가 없음.
	private static boolean checkDriver = false;
	
	// 클래스가 맨 처음 선언되어지는 경우 딱 한번만 실행이 된다.
	static { // static 초기화 블록
		// 1. 드라이버 확인
		try {
			Class.forName(driver);
			checkDriver = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			checkDriver = false;
			e.printStackTrace();
		}
	}
	
	// 연결객체를 전달하는 메서드 선언 - DBUtil.getConnection()
	public static Connection getConnection() throws SQLException {
		if(checkDriver)
			return DriverManager.getConnection(url, id, pw);
		throw new SQLException("드라이버가 존재하지 않습니다.");
	}
	
	// DB처리하면서 사용한 객체 닫기
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
	
		close(con,pstmt);
		rs.close();
	
	}
	
	// Overriding
	// DB처리하면서 사용한 객체 닫기
	public static void close(Connection con, PreparedStatement pstmt) throws SQLException {
		con.close();
		pstmt.close();
	
	}
	
}
