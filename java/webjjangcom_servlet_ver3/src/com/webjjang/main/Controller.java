package com.webjjang.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	// return으로 사용되는 string을 jsp나 url이 된다.
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception;
}
