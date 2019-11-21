package com.webjjang.util.io;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {

	private static final String PREFIX = "/WEB-INF/views/"; // 접두어
	private static final String SURFIX = ".jsp";

	// forward 시킬 jsp를 완성해 주는 메서드
	private static String getJSP(String jsp) {
		return PREFIX + jsp + SURFIX;
	}

	public static void forward(HttpServletRequest request, HttpServletResponse response, String jsp)
			throws ServletException, IOException {
		System.out.println("ViewResolver.forward.jsp" + jsp);
		if (jsp.indexOf("redirect:") == 0) {
			// redirect: 제거
			jsp = jsp.substring("redirect:".length());
			response.sendRedirect(jsp);
			return;
		}
		request.getRequestDispatcher(getJSP(jsp)).forward(request, response);
		return;
	}
}
