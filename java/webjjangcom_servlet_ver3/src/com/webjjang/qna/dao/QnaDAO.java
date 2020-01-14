package com.webjjang.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.webjjang.qna.dto.QnaDTO;
import com.webjjang.util.db.DBUtil;
import com.webjjang.util.page.PageObject;


public class QnaDAO {
	// 객체에서 사용할 DB 정보 -> DBUtil에 다 정의
			// 전역변수로 선언한다.

			
			// service.QnaService -> dao.QnaDAO
			// 1. 질문답변 리스트 데이터 가져오기
			// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런경우에는 예외처리를 반드시 해야하므로
			// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
			
			public List<QnaDTO> list(PageObject pageObject) throws Exception {
				
				System.out.println("QnaDAO.list()");
				
				// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
				List<QnaDTO> list = null;
				
				// 데이터 가져오는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
				// 3. 실행한 쿼리문 작성
				String sql = " select q.no, q.title, q.id, m.name, to_char(q.writeDate, 'yyyy-mm-dd') writeDate, q.hit, q.levNo "
						+ " from qna q, member m where q.id = m.id order by refNo desc, ordNo asc ";
				sql = " select rownum rnum, no, title, id, name, writeDate, hit, levNo "
						+ " from ( "+sql+" ) ";
				sql = " select * from (" +sql+ ") where rnum between ? and ? ";

				
				System.out.println("QnaDAO.list().sql : "+ sql);
				// 4. 실행객체 가져오기 / 데이터 셋팅
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pageObject.getStartRow());
				pstmt.setInt(2, pageObject.getEndRow());
				// 5. 실행
				// select -> executeQuery()로 실행 - ResultSet이 리턴돼서 나옴
				// insert,update, delete-> executeUpdate()로 실생 ->int 1,0
				ResultSet rs = pstmt.executeQuery();
				// 6. 표시 / 저장
				if(rs!=null) {
					// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true, 없으면 false를 리턴한다.
					while(rs.next()) {
						// 최종적으로 저장할 list가 null이면 생성해서 사용가능하도록 해준다.
						// ArrayList는 list의 일종으로 배열을 사용한다.
						if(list == null) list = new ArrayList<QnaDTO>();
						// 질문답변 하나의 데이터를 담는 개체 생성 -> QnaDTO
						QnaDTO dto = new QnaDTO();
						//데이터를 담는다. rs에서 꺼내서 dto에 담는다.
						dto.setNo(rs.getInt("no"));
						dto.setTitle(rs.getString("title"));
						dto.setId(rs.getString("id"));
						dto.setName(rs.getString("name"));
						dto.setWriteDate(rs.getString("writeDate"));
						dto.setHit(rs.getInt("hit"));
						dto.setLevNo(rs.getInt("levNO"));
	
						// 리스트 데이터가 여러개 이므로 데이터를 담은 DTO를 list에 추가시킨다.
						list.add(dto);
					} // end of while(rs.next)
				}// end of if(rs==null)
				// 7. 닫기
				DBUtil.close(con, pstmt, rs);
				
				System.out.println("QnaDAO.list().list : "+ list);
				
				
				return list;
			}// end of list
			
			public int getTotalRow() throws Exception{
				
				System.out.println("QnaDAO.getTotalRow()" );
				
				int totalRow = 0;
				
				
				Connection con = DBUtil.getConnection();
				String sql = " select count(*) cnt from qna  ";
				System.out.println("QnaDAO.getTotalRow().sql : " + sql);
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs != null && rs.next()) {
				 totalRow = rs.getInt("cnt");
				}
				
				DBUtil.close(con, pstmt, rs);
				
				System.out.println("QnaDAO.getTotalRow() : " + totalRow);
				
				return totalRow;	
			}
			// service.QnaService -> dao.QnaDAO
			
			// 2. 질문답변 글보기 데이터 가져오기 - 한개 데이터 - 글번호에 따라서 결정(전달 받는다.)
			// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런경우에는 예외처리를 반드시 해야하므로
			// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
			// QnaController : 실행내용 결정 - 데이터 수집 / 데이터 표시
			// QnaController -> Service -> DAO
			public QnaDTO view(int no) throws Exception {
				
				System.out.println("QnaDAO.view().no : " + no);
				
				// 가져온 결과가 저장되어 지는 변수 -> 리턴해야하므로 리턴타입과 같아야한다.
				QnaDTO dto = null;
				
				// 데이터 가져오는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
				// 3. 실행한 쿼리문 작성
				// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
				String sql = " select q.no, q.title, q.content, q.id, m.name,"
						+ " to_char(q.writeDate, 'yyyy-mm-dd') writeDate,"
						+ " q.hit, q.refNO, q.ordNO, q.levNo, q.parentNo "
						// 일반조건과 조인조건을 묶을 때 and를 사용한다.
						+ " from qna q, member m where q.no = ? and q.id = m.id "
						+ " order by refNo desc, ordNo asc ";
				System.out.println("QnaDAO.view().sql : "+ sql);
				// 4. 실행객체 가져오기 / 데이터 셋팅
				PreparedStatement pstmt = con.prepareStatement(sql);
				// pstmt.setInt(?의 위치, ?를 대체해야할 값)
				pstmt.setInt(1, no);
				// 5. 실행
				ResultSet rs = pstmt.executeQuery();
				// 6. 표시 / 저장
				if(rs!=null && rs.next()) {
				// 질문답변 하나의 데이터를 담는 개체 생성 -> QnaDTO
					dto = new QnaDTO();
					//데이터를 담는다. rs에서 꺼내서 dto에 담는다.
					dto.setNo(rs.getInt("no"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setWriteDate(rs.getString("writeDate"));
					dto.setHit(rs.getInt("hit"));
					dto.setRefNo(rs.getInt("refNO"));
					dto.setOrdNo(rs.getInt("ordNO"));
					dto.setLevNo(rs.getInt("levNO"));
					dto.setParentNo(rs.getInt("parentNO"));
				} // end of if(rs !=null && rs.next())
			// 7. 닫기
				DBUtil.close(con, pstmt, rs);
				
				System.out.println("QnaDAO.view().dto : "+ dto);
				
				
				return dto;
				
			}// end of view()
			
			// service.QnaViewService -> dao.QnaDAO
			// 4-1. Controller.main()->조회 수 를 1 증가시킨다.
			// 답변 데이터를 넣기전에 실행해야만 한다. 
			// 데이터 가져오기 - 한개 데이터  전달받아서 DB에 수정
			// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
			// QnaController : 실행내용 결정 - 데이터 수집 / 데이터 표시
			// QnaController -> Service -> DAO
						
			public void increaseHit(int no) throws Exception {
							
				// 확인해야할 데이터 - 관련글번호, 순서번호
				System.out.println("QnaDAO.increaseOrdNo().dno : " + no);
							
				// 데이터 저장하는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
//				con.commit();
//				con.rollback();
				// 3. 실행한 쿼리문 작성
				// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
				String sql = " update qna set hit = hit + 1"
						+ " where no = ? ";
				System.out.println("QnaDAO.increaseOrdNo().sql : "+ sql);
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
						
			
			// 3.질문 글 쓰기 데이터 가져오기 - 한개 데이터  전달받아서 DB에 저장
			// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
			// QnaController : 실행내용 결정 - 데이터 수집 / 데이터 표시
			// QnaController -> Service -> DAO
			
			// 질문하기
			public int write(QnaDTO dto) throws Exception {
				// 질문제목, 내용, 아이디 -> 나머지는 기본값이라 확인불필요
				System.out.println("QnaDAO.write().dto : " + dto);
				
				// 데이터 저장하는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
				// 3. 실행한 쿼리문 작성
				// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
				String sql = " insert into qna(no, title, content, id, refNo, ordNo, levNo) "
						+ " values(qna_seq.nextval, ?, ?, ?,qna_seq.nextval,1,0) ";
				System.out.println("QnaDAO.write().sql : "+ sql);
				// 4. 실행객체 가져오기 / 데이터 셋팅
				PreparedStatement pstmt = con.prepareStatement(sql);
				// pstmt.setInt(?의 위치, ?를 대체해야할 값)
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getId());
				// 5. 실행
				// select -> executeQuery()
				// insert, update, delete -> executeUpdate()
				int result = pstmt.executeUpdate();
				// 6. 표시 / 저장
				System.out.println("질문하기 성공");
				// 7. 닫기
				DBUtil.close(con, pstmt);
				return result;
					
			}// end of write()
			
			// 4. 답변 글 쓰기 데이터 가져오기 - 한개 데이터  전달받아서 DB에 저장
			// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
			// QnaController : 실행내용 결정 - 데이터 수집 / 데이터 표시
			// QnaController -> Service -> DAO
			
			// 질문하기
			public int answer(QnaDTO dto) throws Exception {
				// 질문제목, 내용, 아이디, 관련변호, 순서번호, 들여쓰기번호, 부모글번호 확인
				System.out.println("QnaDAO.answer().dto : " + dto);
				
				// 데이터 저장하는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
				// 3. 실행한 쿼리문 작성
				// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
				String sql = " insert into qna(no, title, content, id, refNo, ordNo, levNo, parentNo) "
						+ " values(qna_seq.nextval, ?, ?, ?, ?, ?, ?, ?) ";
				System.out.println("QnaDAO.answer().sql : "+ sql);
				// 4. 실행객체 가져오기 / 데이터 셋팅
				PreparedStatement pstmt = con.prepareStatement(sql);
				// pstmt.setInt(?의 위치, ?를 대체해야할 값)
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getId());
				pstmt.setInt(4, dto.getRefNo());
				pstmt.setInt(5, dto.getOrdNo());
				pstmt.setInt(6, dto.getLevNo());
				pstmt.setInt(7, dto.getParentNo());
				// 5. 실행
				// select -> executeQuery()
				// insert, update, delete -> executeUpdate()
				int result = pstmt.executeUpdate();
				// 6. 표시 / 저장
				System.out.println("답변하기 성공");
				// 7. 닫기
				DBUtil.close(con, pstmt);
				return result;
					
			}// end of write()
			
			// 4-1. 답변을 하려면 가져온 순서번호보다 같거나 큰  순서번호를 1 증가시킨다.
			// 답변 데이터를 넣기전에 실행해야만 한다. 
			// 데이터 가져오기 - 한개 데이터  전달받아서 DB에 수정
			// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
			// QnaController : 실행내용 결정 - 데이터 수집 / 데이터 표시
			// QnaController -> Service -> DAO
			
			public void increaseOrdNo(QnaDTO dto) throws Exception {
				
				// 확인해야할 데이터 - 관련글번호, 순서번호
				System.out.println("QnaDAO.increaseOrdNo().dto : " + dto);
				
				// 데이터 저장하는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
//				con.commit();
//				con.rollback();
				// 3. 실행한 쿼리문 작성
				// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
				String sql = " update qna set ordNo = ordNo + 1"
						+ " where refNo = ? and ordNo >= ? ";
				System.out.println("QnaDAO.increaseOrdNo().sql : "+ sql);
				// 4. 실행객체 가져오기 / 데이터 셋팅
				PreparedStatement pstmt = con.prepareStatement(sql);
				// pstmt.setInt(?의 위치, ?를 대체해야할 값)
				pstmt.setInt(1, dto.getRefNo());
				pstmt.setInt(2, dto.getOrdNo());
				// 5. 실행
				// select -> executeQuery()
				// insert, update, delete -> executeUpdate()
				int result = pstmt.executeUpdate();
				// 6. 표시 / 저장
				if(result > 0)
					System.out.println("순서번호 1 증가 성공");
				// 순서번호가 3번까지만 있다. 4번을 답변하고자 한다. -> 같거나 큰 데이터가 없으므로 수정되지 않는다. 
				else
					System.out.println("순서번호 증가 되지않았습니다.");
				// 7. 닫기
				DBUtil.close(con, pstmt);
				
			}// end of increaseOrdNo()
			
			// 5. 질문답변 글수정 데이터 가져오기 - 한개 데이터  전달받아서 DB에 수정
			// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
			// QnaController : 실행내용 결정 - 데이터 수집 / 데이터 표시
			// QnaController -> Service -> DAO
			
			public int update(QnaDTO dto) throws Exception {
				
				// 확인해야할 데이터 - 번호, 제목, 내용
				System.out.println("QnaDAO.update().dto : " + dto);
				
				// 데이터 저장하는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
				// 3. 실행한 쿼리문 작성
				// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
				String sql = " update qna set title = ?, content = ? where no = ? ";
				System.out.println("QnaDAO.update().sql : "+ sql);
				// 4. 실행객체 가져오기 / 데이터 셋팅
				PreparedStatement pstmt = con.prepareStatement(sql);
				// pstmt.setInt(?의 위치, ?를 대체해야할 값)
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getContent());
				pstmt.setInt(3, dto.getNo());
				// 5. 실행
				// select -> executeQuery()
				// insert, update, delete -> executeUpdate()
				int result = pstmt.executeUpdate();
				// 6. 표시 / 저장
				if(result > 0)
					System.out.println("글수정 성공");
				else
					System.out.println("글수정이 되지않았습니다. - 글번호를 확인하세요.");
				// 7. 닫기
				DBUtil.close(con, pstmt);
				return result;
				
			}// end of update()
			
			
			
			//5. 질문답변 글삭제 데이터 가져오기 - 글번호를 전달 받아서 DB에 삭제처리 
				// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
				// QnaController : 실행내용 결정 - 데이터 수집 / 데이터 표시
				// QnaController -> Service -> DAO
			public int delete(int no) throws Exception {
				
				// 확인해야할 데이터 - 번호
				System.out.println("QnaDAO.delete().no : " + no);
				
				// 데이터 저장하는 처리문
				// 1. 드라이버 확인
				// 2. 연결 객체
				Connection con = DBUtil.getConnection();
				// 3. 실행한 쿼리문 작성
				// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
				String sql = " delete from qna where no = ? ";
				System.out.println("QnaDAO.update().sql : "+ sql);
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
					System.out.println("글삭제 성공");
				else
					System.out.println("글삭제가 되지않았습니다. - 글번호를 확인하세요.");
				// 7. 닫기
				DBUtil.close(con, pstmt);
				return result;
			}// end of delete()


				
		}




