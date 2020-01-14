package com.webjjang.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.util.db.DBUtil;
import com.webjjang.util.page.PageObject;

public class NoticeDAO {

	public List<NoticeDTO> list(PageObject pageObject) throws Exception{
		
		System.out.println("NoticeDAO.list()");
		
		List<NoticeDTO> list = null;
		
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select no, title, "
				+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
				+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
				+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, "
				+ " to_char(updateDate, 'yyyy-mm-dd') updateDate "
				+ " from notice order by no desc ";
		sql = " select rownum rnum, no, title, startDate, endDate, writeDate, updateDate from "
				+ " ( " + sql +" ) ";
		sql = " select * from (" +sql+ ") where rnum between ? and ? ";
		System.out.println("NoticeDAO.list().sql : " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, pageObject.getStartRow());
		pstmt.setInt(2, pageObject.getEndRow());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			
			while(rs.next()) {
				if(list == null) list = new ArrayList<NoticeDTO>();
				
				NoticeDTO dto = new NoticeDTO();
				
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setUpdateDate(rs.getString("updateDate"));
				
				list.add(dto);				
			}
			
		}
		
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("NoticeDAO.list().list : " + list);
		
		return list;	
	}

	public int getTotalRow() throws Exception{
		
		System.out.println("NoticeDAO.getTotalRow()" );
		
		int totalRow = 0;
		
		
		Connection con = DBUtil.getConnection();
		String sql = " select count(*) cnt from notice  ";
		System.out.println("NoticeDAO.getTotalRow().sql : " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null && rs.next()) {
		 totalRow = rs.getInt("cnt");
		}
		
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("NoticeDAO.getTotalRow() : " + totalRow);
		
		return totalRow;	
	}
	public NoticeDTO view(int no) throws Exception{
		
		System.out.println("NoticeDAO.view().no : " + no);
		
		NoticeDTO dto = null;
		
		
		Connection con = DBUtil.getConnection();
		String sql = " select no, title, content, "
				+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
				+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
				+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, "
				+ " to_char(updateDate, 'yyyy-mm-dd') updateDate "
				+ " from notice where no = ? ";
		System.out.println("NoticeDAO.view().sql : " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null && rs.next()) {
							
				dto = new NoticeDTO();
				
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setUpdateDate(rs.getString("updateDate"));
		}
		
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("NoticeDAO.list().dto : " + dto);
		
		return dto;	
	}
	
	public int write(NoticeDTO dto) throws Exception{
		
		System.out.println("NoticeDAO.write().dto : " + dto);
		
		
		Connection con = DBUtil.getConnection();
		
		String sql = " insert into notice(no, title, content, "
				+ " startDate, endDate) "
				+ " values(notice_seq.nextval, ?, ?, ?, ?) ";
		System.out.println("NoticeDAO.write().sql : " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getStartDate());
		pstmt.setString(4, dto.getEndDate());
		
		int result = pstmt.executeUpdate();
		
		System.out.println("공지 등록 성공");
		
		DBUtil.close(con, pstmt);
		return result;
		
	}
	public int update(NoticeDTO dto) throws Exception{
		
		System.out.println("NoticeDAO.update().dto" + dto);
		
		
		Connection con = DBUtil.getConnection();
		
		String sql = " update notice set title = ?, content = ?, "
				+ " startDate = ?, endDate = ? "
				+ " where no = ? ";
		
		System.out.println("NoticeDAO.update().sql : " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getStartDate());
		pstmt.setString(4, dto.getEndDate());
		pstmt.setInt(5, dto.getNo());
		
		int result = pstmt.executeUpdate();
		
		System.out.println("공지사항 수정 성공");
		
		DBUtil.close(con, pstmt);
		
		return result;
		
	}
	
	public int delete(int no)throws Exception{
		
		System.out.println("NoticeDAO.delete().no : " + no);
		
		
		Connection con = DBUtil.getConnection();
		
		String sql = " delete from notice "
				+ " where no = ? ";
		
		System.out.println("NoticeDAO.delete().sql : " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		
		int result = pstmt.executeUpdate();
		
		System.out.println("공지사항 삭제 성공");
		
		DBUtil.close(con, pstmt);
		
		return result;
		
	}
	
}
