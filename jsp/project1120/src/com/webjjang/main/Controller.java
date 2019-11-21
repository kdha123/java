package com.webjjang.main;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	
	public String execute(HttpServletRequest request, String uri) throws Exception;
		
}
