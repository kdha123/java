package com.webjjang.exception;

public class NotLoginException extends Exception {


	private static final long serialVersionUID = 1L;

	public NotLoginException() {
		 super("로그인이 필요한 서비스입니다. 로그인을 해주세요.");
	}
}
