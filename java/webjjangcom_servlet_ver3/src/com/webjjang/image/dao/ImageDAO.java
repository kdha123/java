package com.webjjang.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.image.dto.ImageDTO;
import com.webjjang.util.db.DBUtil;
import com.webjjang.util.page.PageObject;
import com.webjjang.util.page.SearchCondition;

public class ImageDAO {

	// service.ImageListService -> dao.ImageDAO
	// 1. 이미지게시판 리스트 데이터 가져오기
	//  데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	//  여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	public List<ImageDTO> list(PageObject pageObject) throws Exception{
		
		System.out.println("ImageDAO.list()");
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴타입과 같아야 한다.
		List<ImageDTO> list = null;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		//    1) 데이터를 정렬시켜서 가져오기.
		String sql = " select no, title, id, "
				+ " to_char(writeDate, 'yyyy-mm-dd') writeDate,  "
				+ " fileName "
				+ " from image ";
		// 검색 쿼리를 뒤에 붙이는 메서드 호출
		sql += SearchCondition.getSearchSQLWithWhere(pageObject);
		sql += " order by no desc ";
		//    2) 위에서 정렬시킨 데이터에 순서 번호를 붙인다.
		sql = " select rownum rnum, no, title, id, writeDate, fileName "
				+" from( " + sql + ") ";
		//    3) 페이지에 맞는 시작 번호와 끝번호 사이의 데이터를 가져온다.
		sql = " select * "
				+" from( " + sql + ") "
				+ " where rnum between ? and ? ";
		System.out.println("ImageDAO.list().sql:"+sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		// 검색 조건 데이터 셋팅
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
		pstmt.setInt(idx++, pageObject.getStartRow());
		pstmt.setInt(idx++, pageObject.getEndRow());
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if(rs != null) {
			// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true,없으면 false를 리턴한다.
			while(rs.next()) {
				// 최종적으로 저장할 list가 null이면 생성해서 사용가능하도록 해준다.
				// ArrayList는 list의 일종으로 배열을 사용한다.(연속된 주소)
				if(list == null) list = new ArrayList<ImageDTO>();
				// 이미지게시판 하나의 데이터를 담는 객체 생성 ->ImageDTO
				ImageDTO dto = new ImageDTO();
				// 데이터를 담는다. rs에서 꺼내서 dto에
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setFileName(rs.getString("fileName"));
				//list를 위해서 작은 파일(s_)로 변환을 해줘야한다.
				// 현재 파일명은 path + 파일명이므로 파일명 바로 앞에 s_를 추가시켜주는 처리를 해서
				// 다시 fileName으로 넣는다.
				String fileName = dto.getFileName();
				int pos = fileName.lastIndexOf("/");
				fileName = fileName.substring(0, pos+1)+ "s_"+ fileName.substring(pos +1);
				dto.setFileName(fileName);
				// 리스트 데이터가 여러개 이므로 데이터를 담은 dto를 list에 추가시킨다.
				list.add(dto);
			} // end of while(rs.next())
		} // end of if(rs == null)
		
		// 7. 닫기
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("ImageDAO.list().list:"+list);
		
		return list;
	} // end of list()
	
	
	// service.ImageListService -> dao.ImageDAO
	// 1-1. 이미지게시판 리스트 데이터 가져오기 - 전체 데이터의 갯수를 가져오는 메서드
	//  데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	//  여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	//  ImageController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	//  ImageController -> Service -> DAO
	public int getTotalRow(PageObject pageObject) throws Exception{
		
		System.out.println("ImageDAO.getTotalRow().pageObject:"+pageObject);
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴타입과 같아야 한다.
		int totalRow = 0;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인	// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " select count(*) cnt from image ";
		sql += SearchCondition.getSearchSQLWithWhere(pageObject);
		System.out.println("ImageDAO.getTotal().sql:"+sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true,없으면 false를 리턴한다.
		if(rs != null && rs.next()) {
			totalRow = rs.getInt("cnt");
		} // end of if(rs != null && rs.next())
		
		// 7. 닫기
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("ImageDAO.getTotalRow().totalRow:"+totalRow);
		
		return totalRow;
	} // end of view()
	
	// service.ImageViewService -> dao.ImageDAO
	// 2. 이미지게시판 글보기 데이터 가져오기 - 한개 데이터 - 글번호에 따라서 결정(전달 받는다.)
	//  데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	//  여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	//  ImageController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	//  ImageController -> Service -> DAO
	public ImageDTO view(int no) throws Exception{
		
		System.out.println("ImageDAO.view().no:" + no);
		
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴타입과 같아야 한다.
		ImageDTO dto = null;
		
		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " select no, title, content, id, "
				+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, "
				+ " fileName "
				+ " from image where no = ? ";
		System.out.println("ImageDAO.list().sql:"+sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true,없으면 false를 리턴한다.
		if(rs != null && rs.next()) {
			// 이미지게시판 하나의 데이터를 담는 객체 생성 ->ImageDTO
			dto = new ImageDTO();
			// 데이터를 담는다. rs에서 꺼내서 dto에
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setId(rs.getString("id"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setFileName(rs.getString("fileName"));
		} // end of if(rs != null && rs.next())
		
		// 7. 닫기
		con.close();
		pstmt.close();
		rs.close();
		
		System.out.println("ImageDAO.list().dto:"+dto);
		
		return dto;
	} // end of view()
	
	
	// service.ImageWriteService -> dao.ImageDAO
	// 3. 이미지게시판 글쓰기 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	//  여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	//  ImageController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	//  ImageController -> Service -> DAO
	public int write(ImageDTO dto) throws Exception{
		
		System.out.println("ImageDAO.write().dto:" + dto);
		
		// 데이터 저장 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " insert into image(no, title, content, id, fileName) "
				+ " values(image_seq.nextval, ?, ?, ?, ?) ";
		System.out.println("ImageDAO.write().sql:"+sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getId());
		pstmt.setString(4, dto.getFileName());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("이미지 등록 성공");
		
		// 7. 닫기
		con.close();
		pstmt.close();
		
		return result;
	} // end of write()
	
	// service.ImageUpdateService -> dao.ImageDAO
	// 4. 이미지게시판 글수정 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 수정처리
	//  여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	//  ImageController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	//  ImageController -> Service -> DAO
	public int update(ImageDTO dto) throws Exception{
		
		// 확인해야할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("ImageDAO.update().dto:" + dto);
		
		// 데이터 저장 처리문
		// 1. 드라이버 확인
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update image set title = ?, content = ? ";
		// 수정인 경우 첨부파일이 들어오지 않으면 수정하지 않는다.
		// 첨부파일이 들어온 경우 처리
		if (dto.getFileName() != null && !dto.getFileName().equals(""))
				sql += " , fileName = ? ";
		sql += " where no = ? ";
		System.out.println("ImageDAO.update().sql:"+sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		int idx = 1;
		pstmt.setString(idx++, dto.getTitle());
		pstmt.setString(idx++, dto.getContent());
		// 첨부파일이 있는 경우 처리
		if (dto.getFileName() != null && !dto.getFileName().equals(""))
			pstmt.setString(idx++, dto.getFileName());
		pstmt.setInt(idx++, dto.getNo());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글수정 성공");
		
		// 7. 닫기
		con.close();
		pstmt.close();
		
		return result;
	} // end of update()

	// service.ImageDeleteService -> dao.ImageDAO
	// 4. 이미지게시판 글삭제 글번호 가져오기 - 글번호 전달 받아서 DB에 삭제처리
	//  여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	//  ImageController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	//  ImageController -> Service -> DAO
	public int delete(int no) throws Exception{
		
		// 확인해야할 데이터 - 번호
		System.out.println("ImageDAO.delete().no:" + no);
		
		// 데이터 저장 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " delete from image "
				+ " where no = ? ";
		System.out.println("ImageDAO.delete().sql:"+sql);
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
		con.close();
		pstmt.close();
		
		return result;
	} // end of delete()
	

	
}
