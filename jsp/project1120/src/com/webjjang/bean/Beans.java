package com.webjjang.bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.webjjang.board.controller.BoardController;
import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.serivce.BoardListService;
import com.webjjang.main.Controller;
import com.webjjang.main.Service;

/**
 * Servlet implementation class Beans
 */
@WebServlet(value = "/Beans",loadOnStartup = 1 )
public class Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//생성된 객체를 저장하는 객체 변수 선언과 생성
	private static Map<String, Object> daos = new HashMap<String, Object>();
	private static Map<String, Service> services = new HashMap<String, Service>();
	private static Map<String, Controller>  controllers = new HashMap<String, Controller>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Beans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		
		//----------------------게시판의 객체 생성 저장------------------
		//dao 생성
		daos.put("boardDAO", new BoardDAO());
		// service 생성
		services.put("boardListService", new BoardListService((BoardDAO) daos.get("boardDAO")));
		controllers.put("boardController", new BoardController(services.get("boardListService")));
	}

	public static Controller getController(String name) {
		// TODO Auto-generated method stub
		return controllers.get(name);
	}

}
