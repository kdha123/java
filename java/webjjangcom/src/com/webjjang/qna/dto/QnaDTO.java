package com.webjjang.qna.dto;

public class QnaDTO {

	private int no, hit, refNo, ordNo, levNo, parentNo;
	private String title, content, id, birth;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		 this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRefNo() {
		return refNo;
	}
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public int getLevNo() {
		return levNo;
	}
	public void setLevNo(int levNo) {
		this.levNo = levNo;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	@Override
	public String toString() {
		return "qnaDTO [no=" + no + ", title=" + title + ", content=" + content + ", id=" + id + ", birth=" + birth
				+ ", hit=" + hit + ", refNo=" + refNo + ", ordNo=" + ordNo + ", levNo=" + levNo + ", parentNo="
				+ parentNo + "]";
	}

}
