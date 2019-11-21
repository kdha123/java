package com.webjjang.main;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.bean.Beans;
import com.webjjang.util.io.ViewResolver;

/**
 * Servlet implementation class FrontController
 */

// web.xml에서 servlet을 등록
//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 실행할 Controller 객체 선언 및 DI
	private Controller boardController = Beans.getController("boardController");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// forward 시킬 문자열 저장 변수 jsp
		String jsp="";
		try {
			System.out.println("FrontController.service()");
			String uri = request.getServletPath();
			System.out.println(uri);
			if (uri.indexOf("/board") == 0) {
				jsp = boardController.execute(request, uri);
			}
			ViewResolver.forward(request, response, jsp);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}

}
