package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.dto.BoardDTO;

public class BoardDAO {
	
	// ��ü���� ����� DB ���� -> list(), view().. �ٸ� �޼��忡�� �� �ʿ�� �ϱ� ������
	// ���������� �����Ѵ�.
	String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
	String id = "c##java04";
	String pw = "java04";
	
	// ����Ŭ ����̹�
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	// service.BoardService -> dao.BoardDAO
	// 1. �Խ��� ����Ʈ ������ ��������
	// ������ �������Ⱑ �����ϸ� ����Ϸ� �� ���� ����. �׷���쿡�� ����ó���� �ݵ�� �ؾ��ϹǷ�
	// ���⼭�� ����ó������ �ʰ� throw ��Ű�� ������ �� �� �ִ�.
	
	public List<BoardDTO> list() throws Exception {
		
		System.out.println("BoardDAO.list()");
		
		// ������ ����� ����Ǿ� ���� ���� -> �����ؾ��ϹǷ� ����Ÿ�԰� ���ƾ��Ѵ�.
		List<BoardDTO> list = null;
		
		// ������ �������� ó����
		// 1. ����̹� Ȯ��
		Class.forName(driver);
		// 2. ���� ��ü
		Connection con = DriverManager.getConnection(url,id,pw);
		// 3. ������ ������ �ۼ�
		String sql = " select no, title, writer, to_char(writeDate, 'yyyy-mm-dd') writeDate, hit "
				+ "from board order by no desc ";
		System.out.println("BoardDAO.list().sql : "+ sql);
		// 4. ���ఴü �������� / ������ ����
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 5. ����
		ResultSet rs = pstmt.executeQuery();
		// 6. ǥ�� / ����
		if(rs!=null) {
			// rs.next() : ���� �����ͷ� �Ѿ�鼭 �����Ͱ� ������ true, ������ false�� �����Ѵ�.
			while(rs.next()) {
				// ���������� ������ list�� null�̸� �����ؼ� ��밡���ϵ��� ���ش�.
				// ArrayList�� list�� �������� �迭�� ����Ѵ�.
				if(list == null) list = new ArrayList<BoardDTO>();
				// �Խ��� �ϳ��� �����͸� ��� ��ü ���� -> BoardDTO
				BoardDTO dto = new BoardDTO();
				//�����͸� ��´�. rs���� ������ dto�� ��´�.
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setHit(rs.getInt("hit"));
				// ����Ʈ �����Ͱ� ������ �̹Ƿ� �����͸� ���� DTO�� list�� �߰���Ų��.
				list.add(dto);
			} // end of while(rs.next)
		}// end of if(rs==null)
		// 7. �ݱ�
		con.close();
		pstmt.close();
		rs.close();
		
		System.out.println("BoardDAO.list().list : "+ list);
		
		
		return list;
	}// end of list
	
	// service.BoardService -> dao.BoardDAO
	
	
	// 2. �Խ��� �ۺ��� ������ �������� - �Ѱ� ������ - �۹�ȣ�� ���� ����(���� �޴´�.)
	// ������ �������Ⱑ �����ϸ� ����Ϸ� �� ���� ����. �׷���쿡�� ����ó���� �ݵ�� �ؾ��ϹǷ�
	// ���⼭�� ����ó������ �ʰ� throw ��Ű�� ������ �� �� �ִ�.
	// BoardController : ���೻�� ���� - ������ ���� / ������ ǥ��
	// BoardController -> Service -> DAO
	public BoardDTO view(int no) throws Exception {
		
		System.out.println("BoardDAO.view().no : " + no);
		
		// ������ ����� ����Ǿ� ���� ���� -> �����ؾ��ϹǷ� ����Ÿ�԰� ���ƾ��Ѵ�.
		BoardDTO dto = null;
		
		// ������ �������� ó����
		// 1. ����̹� Ȯ��
		Class.forName(driver);
		// 2. ���� ��ü
		Connection con = DriverManager.getConnection(url,id,pw);
		// 3. ������ ������ �ۼ�
		// ���� �� �߿��� ?�� ���� ��ü ��Ű�� ��ü ���ڿ� �ش��̵ȴ�.
		String sql = " select no, title, content, writer, to_char(writeDate, 'yyyy-mm-dd') writeDate, hit "
				+ "from board where no = ? ";
		System.out.println("BoardDAO.view().sql : "+ sql);
		// 4. ���ఴü �������� / ������ ����
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?�� ��ġ, ?�� ��ü�ؾ��� ��)
		pstmt.setInt(1, no);
		// 5. ����
		ResultSet rs = pstmt.executeQuery();
		// 6. ǥ�� / ����
		if(rs!=null && rs.next()) {
		// �Խ��� �ϳ��� �����͸� ��� ��ü ���� -> BoardDTO
			dto = new BoardDTO();
			//�����͸� ��´�. rs���� ������ dto�� ��´�.
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setWriter(rs.getString("writer"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setHit(rs.getInt("hit"));
			// ����Ʈ �����Ͱ� ������ �̹Ƿ� �����͸� ���� DTO�� list�� �߰���Ų��.
		} // end of if(rs !=null && rs.next())
	// 7. �ݱ�
		con.close();
		pstmt.close();
		rs.close();
		
		System.out.println("BoardDAO.list().dto : "+ dto);
		
		
		return dto;
	}// end of list
}
