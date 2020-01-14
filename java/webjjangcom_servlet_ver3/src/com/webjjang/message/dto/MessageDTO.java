package com.webjjang.message.dto;

public class MessageDTO {
	
	private int no;
	private String content, sender, sendDate, accepter, acceptDate;
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
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getAccepter() {
		return accepter;
	}
	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}
	public String getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}
	@Override
	public String toString() {
		return "MessageDTO [no=" + no + ", content=" + content + ", sender=" + sender + ", sendDate=" + sendDate
				+ ", accepter=" + accepter + ", acceptDate=" + acceptDate + "]";
	}

}
