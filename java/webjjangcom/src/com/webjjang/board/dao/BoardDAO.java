package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.util.db.DBUtil;

public class BoardDAO {
	
	// 객체에서 사용할 DB 정보 -> list(), view().. 다른 메서드에서 다 필요로 하기 때문에
	// 전역변수로 선언한다.
	String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
	String id = "c##java04";
	String pw = "java04";
	
	// 오라클 드라이버
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	// service.BoardService -> dao.BoardDAO
	// 1. 게시판 리스트 데이터 가져오기
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런경우에는 예외처리를 반드시 해야하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	
	public List<BoardDTO> list() throws Exception {
		
		System.out.println("BoardDAO.list()");
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
		List<BoardDTO> list = null;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문 작성
		String sql = " select no, title, writer, to_char(writeDate, 'yyyy-mm-dd') writeDate, hit "
				+ "from board order by no desc ";
		System.out.println("BoardDAO.list().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if(rs!=null) {
			// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true, 없으면 false를 리턴한다.
			while(rs.next()) {
				// 최종적으로 저장할 list가 null이면 생성해서 사용가능하도록 해준다.
				// ArrayList는 list의 일종으로 배열을 사용한다.
				if(list == null) list = new ArrayList<BoardDTO>();
				// 게시판 하나의 데이터를 담는 개체 생성 -> BoardDTO
				BoardDTO dto = new BoardDTO();
				//데이터를 담는다. rs에서 꺼내서 dto에 담는다.
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setHit(rs.getInt("hit"));
				// 리스트 데이터가 여러개 이므로 데이터를 담은 DTO를 list에 추가시킨다.
				list.add(dto);
			} // end of while(rs.next)
		}// end of if(rs==null)
		// 7. 닫기
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("BoardDAO.list().list : "+ list);
		
		
		return list;
	}// end of list
	
	// service.BoardService -> dao.BoardDAO
	
	
	// 2. 게시판 글보기 데이터 가져오기 - 한개 데이터 - 글번호에 따라서 결정(전달 받는다.)
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런경우에는 예외처리를 반드시 해야하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public BoardDTO view(int no) throws Exception {
		
		System.out.println("BoardDAO.view().no : " + no);
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
		BoardDTO dto = null;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인
		Class.forName(driver);
		// 2. 연결 객체
		Connection con = DriverManager.getConnection(url,id,pw);
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " select no, title, content, writer, to_char(writeDate, 'yyyy-mm-dd') writeDate, hit "
				+ "from board where no = ? ";
		System.out.println("BoardDAO.view().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if(rs!=null && rs.next()) {
		// 게시판 하나의 데이터를 담는 개체 생성 -> BoardDTO
			dto = new BoardDTO();
			//데이터를 담는다. rs에서 꺼내서 dto에 담는다.
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setWriter(rs.getString("writer"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setHit(rs.getInt("hit"));
			// 리스트 데이터가 여러개 이므로 데이터를 담은 DTO를 list에 추가시킨다.
		} // end of if(rs !=null && rs.next())
	// 7. 닫기
		con.close();
		pstmt.close();
		rs.close();
		
		System.out.println("BoardDAO.list().dto : "+ dto);
		
		
		return dto;
	}// end of view()
	
	
	// 3. 게시판 글쓰기 데이터 가져오기 - 한개 데이터  전달받아서 DB에 저장
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	
	public void write(BoardDTO dto) throws Exception {
		
		System.out.println("BoardDAO.write().dto : " + dto);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		Class.forName(driver);
		// 2. 연결 객체
		Connection con = DriverManager.getConnection(url,id,pw);
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " insert into board(no, title, content, writer) "
				+ "values(board_seq.nextval, ?, ?, ?) ";
		System.out.println("BoardDAO.write().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글쓰기 성공");
		// 7. 닫기
		con.close();
		pstmt.close();
			
	}// end of write()
	
	
	// 4. 게시판 글수정 데이터 가져오기 - 한개 데이터  전달받아서 DB에 수정
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	
	public void update(BoardDTO dto) throws Exception {
		
		// 확인해야할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.update().dto : " + dto);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		Class.forName(driver);
		// 2. 연결 객체
		Connection con = DriverManager.getConnection(url,id,pw);
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update board set title = ?, content = ?, writer = ? where no = ? ";
		System.out.println("BoardDAO.update().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		pstmt.setInt(4, dto.getNo());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글수정 성공");
		// 7. 닫기
		con.close();
		pstmt.close();
		
	}// end of update()
	
	
	
	//5. 게시판 글삭제 데이터 가져오기 - 글번호를 전달 받아서 DB에 삭제처리 
		// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
		// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
		// BoardController -> Service -> DAO
	public void delete(int no) throws Exception {
		
		// 확인해야할 데이터 - 번호
		System.out.println("BoardDAO.delete().no : " + no);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		Class.forName(driver);
		// 2. 연결 객체
		Connection con = DriverManager.getConnection(url,id,pw);
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " delete from board where no = ? ";
		System.out.println("BoardDAO.update().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글삭제 성공");
		// 7. 닫기
		con.close();
		pstmt.close();
		
	}// end of update()


		
}
