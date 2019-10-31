/*
 * ȸ�� ������ �����ϴ� ��ü
 * DB �÷��� ���缭 �ۼ��Ѵ�. + ó���� ���
 */
package com.webjjang.member.dto;

public class memberDTO {

	// private - �������� : ���� Ŭ���� �������� ����Ѵ�.
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String tel;
	private String email;
	private String regDate;
	private String conDate;
	private String status;
	private int grade;
	
	// �����͸� ������ �� : getMethod�� �ۼ�
	// �����͸� ���� �� : setMethod�� �ۼ�
	// ������ �ȵǴ� �����͵��� set�� ����.
	// �����̳� ������ ������ �־ ȿ�����̴�.
	// �����ӿ�ũ : JSP, Spring -> �����ϰ��ִ�. -> property(get,set�� ����� ��)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getConDate() {
		return conDate;
	}
	public void setConDate(String conDate) {
		this.conDate = conDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	// �������� ������ Ȯ�ο�
	// ������̼� - Over ride <-> Over load
	@Override 
	public String toString() {
		return "memberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", birth=" + birth
				+ ", tel=" + tel + ", email=" + email + ", regDate=" + regDate + ", conDate=" + conDate + ", status="
				+ status + ", grade=" + grade + "]";
	}
}
