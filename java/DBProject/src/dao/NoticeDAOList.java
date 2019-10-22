package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDAOList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// DB �ʿ��� ���� ����
		String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
		String id = "c##java04";
		String pw = "java04";
		// � ����̹�(DB �����Ű�� ���α׷�)���� �� �� �ֵ��� ó���ؾ��Ѵ�.
		String driver = "oracle.jdbc.driver.OracleDriver";
		// ����Ŭ ����
		try {
		// ����ó��
			System.out.println("����ó�� ����");
			System.out.println("����̹� Ȯ��");
		// 1. ����̹� Ȯ��
			Class.forName(driver);
		// 2. DB�� ����
			System.out.println("����Ŭ ���� �õ�");
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("������ : "+ con);
		// 3. ������ ������ �ۼ�
			String sql = " select no, title, content, startDate, endDate, writeDate, updateDate from notice  ";
		// 4. ���� ��ü���� ���ఴü�� ������ �����Ѵ�.
			PreparedStatement pstmt = con.prepareStatement(sql);
		// 5. select -> ������ �������� - ResultSet(DB table ����
			ResultSet rs = pstmt.executeQuery();
		// 6. ������ ������ ǥ�� / ����(DTO->List)
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
			// 7. ����� ��ü �ݱ�- con, pstmt, rs
			con.close();
			pstmt.close();
			rs.close();
			System.out.println("����ó���� ��");
			// ����ó��
	} catch ( ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	}

}
