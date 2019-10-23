package ch08exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

	public static void main(String[] args) {
		
		// DB �ʿ��� ���� ����
		String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
		String id = "c##java04";
		String pw = "java04";
		
		// � ����̹�(DB �����Ű�� ���α׷�)���� �� �� �ֵ��� ó���ؾ��Ѵ�.
		// static���� ������� ���α׷��� �ڵ� �ε� ��ų �� �ִ�.
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		// ����Ŭ ����
		// try(�ڿ���ü) -> �̷� �������� ����ϸ� try�ȿ� ó���� ������ �ڵ����� �ڿ��� ��ȯ�Ѵ�.
		try(Connection con = DriverManager.getConnection(url, id, pw);) {
			// ����ó��
			System.out.println("����ó�� ����");
			System.out.println("����̹� Ȯ��");
			// 1. ����̹� Ȯ��
			Class.forName(driver);
			
			// 2. DB�� ����
			System.out.println("����Ŭ ���� �õ�");
//			Connection con = DriverManager.getConnection(url, id, pw);
			System.out.println("������:"+con);
			
			// 3. ������ ������ �ۼ�
			String sql = " select no, title, writer, writeDate, hit from board ";
			
			// 4. ���� ��ü���� ���ఴü�� ������ �����Ѵ�.
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// 5. select -> ������ �������� - ResultSet(DB table ����)
			//    insert, update, delete -> �����ͺ����� �Ǿ���. �ȵƴ�. 1 / 0
			
			ResultSet rs = pstmt.executeQuery();
			
			// 6. ������ ������ ǥ�� / ����(DTO->List)
			if(rs!=null) {
				while(rs.next()) { // ���� ������ -> ������ false / ������ ���� �����ͷ� �̵� true
					System.out.println(rs.getInt("no"));
					System.out.println(rs.getString("title"));
					System.out.println(rs.getString("writer"));
					System.out.println(rs.getString("writeDate"));
					System.out.println(rs.getInt("hit"));
				}
			}
			// 7. ����� ��ü �ݱ�- con, pstmt, rs
			// con -> try(�ڿ���ü) �������� ��������Ƿ� �ڵ� �ڿ� ��ȯ�� �̷������.
//			con.close();
			pstmt.close();
			rs.close();
			System.out.println("����ó���� ��");
		} catch (ClassNotFoundException | SQLException e) {
			// ����ó��
			e.printStackTrace();
		}

	}

}
