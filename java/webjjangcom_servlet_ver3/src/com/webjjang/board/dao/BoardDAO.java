package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.dto.BoardReplyDTO;
import com.webjjang.util.db.DBUtil;
import com.webjjang.util.page.PageObject;
import com.webjjang.util.page.SearchCondition;

public class BoardDAO {
	
	public List<BoardDTO> list(PageObject pageObject) throws Exception {
		
		System.out.println("BoardDAO.list()");
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
		List<BoardDTO> list = null;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문 작성
		//  1) 데이터를 정렬시켜서 가져오기.
		String sql = " select no, title, writer, to_char(writeDate, 'yyyy-mm-dd') writeDate, hit "
				+ " from board ";
//		if(pageObject.getWord() != null) {
//			sql += " where 1 = 2 ";
//			if(pageObject.getKey().indexOf("t")>=0)
//				sql += " or title like ? ";
//			if(pageObject.getKey().indexOf("c")>=0)
//				sql += " or content like ? ";
//			if(pageObject.getKey().indexOf("w")>=0)
//				sql += " or writer like ? ";
//		}
		sql += SearchCondition.getSearchSQLWithWhere(pageObject);
		sql += " order by no desc ";
		// 2) 위에서 정렬 시킨 데이터에 순서 번호를 붙인다.
		sql = " select rownum rnum, no, title, writer, writeDate, hit from( " + sql + ")";
		
		// 3) 페이지에 맞는 시작번호와 끝 번호 사이의 데이터를 가져온다.
		sql = " select * from(" + sql + ") "
				+ " where rnum between ? and ? " ;
		
		System.out.println("BoardDAO.list().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
//		if(pageObject.getWord() != null) {
//			sql += " where 1 = 2 ";
//			if(pageObject.getKey().indexOf("t")>=0)
//				pstmt.setString(idx++, "%" + pageObject.getWord()+ "%");
//			if(pageObject.getKey().indexOf("c")>=0)
//				pstmt.setString(idx++, "%" + pageObject.getWord()+ "%");
//			if(pageObject.getKey().indexOf("w")>=0)
//				pstmt.setString(idx++, "%" + pageObject.getWord()+ "%");
//		}
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
		pstmt.setInt(idx++, pageObject.getStartRow());
		pstmt.setInt(idx++, pageObject.getEndRow());
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
	
	
	// 1-1. 게시판 리스트 데이터 가져오기 - 전체 데이터의 갯수를 가져오는 메서드 
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런경우에는 예외처리를 반드시 해야하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public int getTotalRow(PageObject pageObject) throws Exception {
		
		System.out.println("BoardDAO.getTotalRow()");
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
		int totalRow = 0;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " select count(*) cnt from board ";
		sql += SearchCondition.getSearchSQLWithWhere(pageObject);
		System.out.println("BoardDAO.getTotal().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);

		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if(rs!=null && rs.next()) {
			totalRow = rs.getInt("cnt");
		} // end of if(rs !=null && rs.next())
		// 7. 닫기
		DBUtil.close(con, pstmt, rs);
		
		
		System.out.println("BoardDAO.getTotalRow().totalRow : "+ totalRow);
		
		
		return totalRow;
	}// end of view()
	
	public BoardDTO view(int no) throws Exception {
		
		System.out.println("BoardDAO.view().no : " + no);
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
		BoardDTO dto = null;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
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
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("BoardDAO.view().dto : "+ dto);
		
		
		return dto;
	}// end of view()
	
	public void increaseHit(int no) throws Exception {
		
		// 확인해야할 데이터 - 관련글번호, 순서번호
		System.out.println("BoardDAO.increaseHit().no : " + no);
					
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
//		con.commit();
//		con.rollback();
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update board set hit = hit + 1"
				+ " where no = ? ";
		System.out.println("BoardDAO.increaseHit().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		if(result > 0)
			System.out.println("조회수1 증가 성공");
		// 순서번호가 3번까지만 있다. 4번을 답변하고자 한다. -> 같거나 큰 데이터가 없으므로 수정되지 않는다. 
		else
			{System.out.println("조회수 1 증가 되지않았습니다.");
			throw new Exception("조회수 1증가처리 중 오류");
			}
		// 7. 닫기
		DBUtil.close(con, pstmt);
		
	}// end of increaseHit()
	
	// 3. 게시판 글쓰기 데이터 가져오기 - 한개 데이터  전달받아서 DB에 저장
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	
	public int write(BoardDTO dto) throws Exception {
		
		System.out.println("BoardDAO.write().dto : " + dto);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
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
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글쓰기 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
			
		return result;
	}// end of write()
	
	
	// 4. 게시판 글수정 데이터 가져오기 - 한개 데이터  전달받아서 DB에 수정
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	
	public int update(BoardDTO dto) throws Exception {
		
		// 확인해야할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.update().dto : " + dto);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
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
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글수정 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
		return result;
	}// end of update()
	
	
	
	//5. 게시판 글삭제 데이터 가져오기 - 글번호를 전달 받아서 DB에 삭제처리 
		// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
		// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
		// BoardController -> Service -> DAO
	public int delete(int no) throws Exception {
		
		// 확인해야할 데이터 - 번호
		System.out.println("BoardDAO.delete().no : " + no);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
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
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글삭제 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
		return result;
	}// end of delete()

	public int writeReply(BoardReplyDTO dto) throws Exception {
		
		System.out.println("BoardReplyDAO.writeReply().dto : " + dto);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " insert into board_rep(rno, no, content, writer) "
				+ "values(board_rep_seq.nextval, ?, ?, ?) ";
		System.out.println("BoardReplyDAO.writeReply().sql : "+ sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, dto.getNo());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("댓글쓰기 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
		
		return result;
	}// end of write()	
	public List<BoardReplyDTO> replyList(int no) throws Exception {
		
		System.out.println("BoardDAO.replyList().no" + no);
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
		List<BoardReplyDTO> list = null;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문 작성
		//  1) 데이터를 정렬시켜서 가져오기.
		String sql = " select rno,no, writer, to_char(writeDate, 'yyyy-mm-dd') writeDate, content "
				+ " from board_rep where no = ? order by rno desc ";
		
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if(rs!=null) {
			// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true, 없으면 false를 리턴한다.
			while(rs.next()) {
				// 최종적으로 저장할 list가 null이면 생성해서 사용가능하도록 해준다.
				// ArrayList는 list의 일종으로 배열을 사용한다.
				if(list == null) list = new ArrayList<BoardReplyDTO>();
				// 게시판 하나의 데이터를 담는 개체 생성 -> BoardDTO
				BoardReplyDTO dto = new BoardReplyDTO();
				//데이터를 담는다. rs에서 꺼내서 dto에 담는다.
				dto.setRno(rs.getInt("rno"));
				dto.setNo(rs.getInt("no"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				// 리스트 데이터가 여러개 이므로 데이터를 담은 DTO를 list에 추가시킨다.
				list.add(dto);
			} // end of while(rs.next)
		}// end of if(rs==null)
		// 7. 닫기
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("BoardDAO.list().list : "+ list);
		
		
		return list;
	}// end of list
	
	public int replyUpdate(BoardReplyDTO dto) throws Exception {
		
		// 확인해야할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.replyUpdate().dto : " + dto);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update board_rep set content = ? where rno = ? ";
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getContent());
		pstmt.setInt(2, dto.getRno());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글수정 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
		return result;
	}// end of update()
	public int replyDelete(int rno) throws Exception {
		
		// 확인해야할 데이터 - 번호
		System.out.println("BoardDAO.replyDelete().no : " + rno);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " delete from board_rep where rno = ? ";
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, rno);
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글삭제 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
		return result;
	}// end of delete()
}
