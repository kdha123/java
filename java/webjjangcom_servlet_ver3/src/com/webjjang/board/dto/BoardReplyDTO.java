package com.webjjang.board.dto;

public class BoardReplyDTO {

	private int rno, no;
	private String content, writer, writeDate;
	
	// 댓글 달기용 생성자
	public BoardReplyDTO(int no, String content, String writer) {
		super();
		this.no = no;
		this.content = content;
		this.writer = writer;
	}
	
	
	// 댓글 수정용 생성자
	public BoardReplyDTO(int rno, String content) {
		// TODO Auto-generated constructor stub
		this.rno = rno;
		this.content = content;
	}
	
	public BoardReplyDTO() {};
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", no=" + no + ", content=" + content + ", writer=" + writer + ", writeDate="
				+ writeDate + "]";
	}
	
	
}
